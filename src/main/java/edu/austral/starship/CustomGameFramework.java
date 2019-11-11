package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.factories.ImageEntityFactory;
import edu.austral.starship.own.interfaces.Entity;
import edu.austral.starship.own.interfaces.EntityFactory;
import edu.austral.starship.own.view.ImageView;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class CustomGameFramework implements GameFramework {

    private List<Entity> entities;
    private ShipController playerOneShipController;
    private ShipController playerTwoShipController;
    private CollisionEngine<Entity> collisionEngine;
    private EntityFactory entityFactory;
    private int MAX_WIDTH = 1000;
    private int MAX_HEIGHT = 1000;
    private final String BACKGROUND_PATH = "src/main/java/edu/austral/starship/own/resources/death_star.jpeg";
    private final String XWING_PATH = "src/main/java/edu/austral/starship/own/resources/xwing---1_1_1024x_ea5a2292-932.png";
    private final String TIE_FIGHTER_PATH = "src/main/java/edu/austral/starship/own/resources/rsz_tie-fighter.png";
    private final String ASTEROID_PATH = "src/main/java/edu/austral/starship/own/resources/better_asteroid.png";
    private final String BULLET_PATH = "src/main/java/edu/austral/starship/own/resources/green_laser.png";
    private final String POWERUP_PATH = "src/main/java/edu/austral/starship/own/resources/rsz_1powerup.png";
    private final String REBEL_LOGO_PATH = "src/main/java/edu/austral/starship/own/resources/rsz_rebels.png";
    private final String EMPIRE_LOGO_PATH = "src/main/java/edu/austral/starship/own/resources/rsz_empire.png";
    private PImage background;
    private PImage bullets;
    private PImage empireLogo;
    private PImage rebelsLogo;
    private double POWERUP_PROBABILITIES = 9.95;
    private double ASTEROID_PROBABILITIES = 9.0;
    private static final boolean MULTIPLAYER = true;
    private boolean mustReset = false;


    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {

        background = imageLoader.load(BACKGROUND_PATH);
        MAX_WIDTH = background.width;
        MAX_HEIGHT = background.height;
        windowsSettings
                .setSize(MAX_WIDTH, MAX_HEIGHT);
        background.height = MAX_HEIGHT;
        background.width = MAX_WIDTH;
        PImage playerOneShip = imageLoader.load(XWING_PATH);
        PImage playerTwoShip = imageLoader.load(TIE_FIGHTER_PATH);
        PImage asteroids = imageLoader.load(ASTEROID_PATH);
        bullets = imageLoader.load(BULLET_PATH);
        empireLogo = imageLoader.load(EMPIRE_LOGO_PATH);
        rebelsLogo = imageLoader.load(REBEL_LOGO_PATH);
        PImage powerUp = imageLoader.load(POWERUP_PATH);

        entities = new ArrayList<>();
        entityFactory = new ImageEntityFactory(playerOneShip, playerTwoShip, asteroids, bullets, powerUp);
        collisionEngine = new CollisionEngine<>();
        playerOneShipController = entityFactory.createXwing(MAX_WIDTH / 2 - 20, MAX_HEIGHT / 2);
        entities.add(playerOneShipController);


        if (MULTIPLAYER) {
            playerTwoShipController = entityFactory.createTieFighter(MAX_WIDTH / 2 - 40, MAX_HEIGHT / 2);
            entities.add(playerTwoShipController);
        }

    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {

        graphics.textSize = 32;
        graphics.fill(255);

        List<Entity> toDelete = new ArrayList<>();

        if (!mustReset) {
            if (keySet.contains(38)) {
                playerOneShipController.moveForward();
            }

            if (keySet.contains(40)) {
                playerOneShipController.moveBackward();
            }

            if (keySet.contains(37)) {
                playerOneShipController.moveLeft();
            }

            if (keySet.contains(39)) {
                playerOneShipController.moveRight();
            }

            if (keySet.contains(32)) {
                try {

                    BulletController bulletController = playerOneShipController.fire();
                    bulletController.setView(new ImageView(bullets));
                    entities.add(bulletController);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }

            if (MULTIPLAYER) {
                if (keySet.contains(87)) {
                    playerTwoShipController.moveForward();
                }

                if (keySet.contains(83)) {
                    playerTwoShipController.moveBackward();
                }

                if (keySet.contains(65)) {
                    playerTwoShipController.moveLeft();
                }

                if (keySet.contains(68)) {
                    playerTwoShipController.moveRight();
                }

                if (keySet.contains(17)) {
                    try {
                        BulletController bulletController = playerTwoShipController.fire();
                        bulletController.setView(new ImageView(bullets));
                        entities.add(bulletController);
                    } catch (Exception e) {
                        System.err.println("You have died. You cannot shoot anymore. Please reset the game.");
                    }
                }
            }
        }


        collisionEngine.checkCollisions(entities);

        graphics.background(background);


        for (Entity entity : entities) {
            if (entity.isInsideScreen(MAX_HEIGHT, MAX_WIDTH)) {
                entity.offFrame();
            }
            entity.move();
            entity.draw(graphics);
            if (!entity.shouldDraw()) {
                toDelete.add(entity);
            }
        }

        //score graphics
        graphics.text("Player One Score: " + playerOneShipController.model.getPoints(), 0, 10);

        if (MULTIPLAYER) {
            graphics.text("Player Two Score: " + playerTwoShipController.model.getPoints(), 0, 20);
        }

        //Final result text
        if (!MULTIPLAYER) {
            if (!playerOneShipController.isAlive()) {
                graphics.text("You lost!", MAX_WIDTH / 2, MAX_HEIGHT / 2);
                mustReset = true;
            }
        } else {
            if (playerOneShipController.isAlive() && !playerTwoShipController.isAlive()) {
                graphics.image(rebelsLogo, MAX_WIDTH / 2, MAX_HEIGHT / 2);
                graphics.text("The Rebel Alliance won!", MAX_WIDTH / 2 - 20, MAX_HEIGHT / 2);
                mustReset = true;
            } else if (!playerOneShipController.isAlive() && playerTwoShipController.isAlive()) {
                graphics.image(empireLogo, MAX_WIDTH / 2, MAX_HEIGHT / 2);
                graphics.text("The Galactic Empire won!", MAX_WIDTH / 2 - 20, MAX_HEIGHT / 2);
                mustReset = true;
            }
        }


        randomAsteroidCreation(entities, entityFactory, MAX_WIDTH, MAX_HEIGHT);
        randomDoubleDamageCreation(entities, entityFactory, MAX_WIDTH, MAX_HEIGHT);

        entities.removeAll(toDelete);
    }

    private void randomDoubleDamageCreation(List<Entity> entities, EntityFactory entityFactory, int max_width, int max_height) {
        if (ThreadLocalRandom.current().nextDouble(10) > POWERUP_PROBABILITIES) {
            Vector2 edge = createRandomEdgeVector(max_width, max_height);
            entities.add(entityFactory.createDoubleDamagePowerUp((int) edge.getX(), (int) edge.getY()));
        }
    }

    private void randomAsteroidCreation(List<Entity> entities, EntityFactory entityFactory, int max_width, int max_height) {
        if (ThreadLocalRandom.current().nextDouble(10) > ASTEROID_PROBABILITIES) {
            Vector2 edge = createRandomEdgeVector(max_width, max_height);
            entities.add(entityFactory.createAsteroid((int) edge.getX(), (int) edge.getY()));
        }
    }

    private boolean fiftyFiftyChance() {
        return ThreadLocalRandom.current().nextInt(10) > 5;
    }

    private Vector2 createRandomEdgeVector(int max_width, int max_height) {
        double random = ThreadLocalRandom.current().nextDouble(0, 1);
        if (fiftyFiftyChance()) {
            //widht va a ser extremo, height va a ser random
            if (fiftyFiftyChance()) {
                //width va a ser max
                return Vector2.vector(max_width, (float) (max_height * random));
            } else {
                //width va a ser 0
                return Vector2.vector(0, (float) ((float) max_height * random));
            }
        } else {
            //widht va a ser random, height va a ser extremo
            if (fiftyFiftyChance()) {
                //height va a ser max
                return Vector2.vector((float) (max_width * random), max_height);
            } else {
                //height va a ser 0
                return Vector2.vector((float) (max_width * random), 0);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
