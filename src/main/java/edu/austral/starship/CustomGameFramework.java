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
    private ShipController shipController;
    private CollisionEngine<Entity> collisionEngine;
    private EntityFactory entityFactory;
    private int MAX_WIDTH = 1000;
    private int MAX_HEIGHT = 1000;
    private final String BACKGROUND_PATH = "/home/rodrigo/projects/starships/src/main/java/edu/austral/starship/own/resources/death_star.jpeg";
    private final String SHIP_PATH = "/home/rodrigo/projects/starships/src/main/java/edu/austral/starship/own/resources/xwing---1_1_1024x_ea5a2292-932.png";
    private final String ASTEROID_PATH = "/home/rodrigo/projects/starships/src/main/java/edu/austral/starship/own/resources/better_asteroid.png";
    private final String BULLET_PATH = "/home/rodrigo/projects/starships/src/main/java/edu/austral/starship/own/resources/green_laser.png";
    private final String POWERUP_PATH = "/home/rodrigo/projects/starships/src/main/java/edu/austral/starship/own/resources/rsz_1powerup.png";
    private PImage background;
    private PImage bullets;
    private int POWERUP_PROBABILITIES = 8;
    private int ASTEROID_PROBABILITIES = 30;


    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        background = imageLoader.load(BACKGROUND_PATH);
        MAX_WIDTH = background.width;
        MAX_HEIGHT = background.height;
        windowsSettings
                .setSize(MAX_WIDTH, MAX_HEIGHT);
        background.height = MAX_HEIGHT;
        background.width = MAX_WIDTH;
        PImage ship = imageLoader.load(SHIP_PATH);
        PImage asteroids = imageLoader.load(ASTEROID_PATH);
        bullets = imageLoader.load(BULLET_PATH);
        PImage powerUp = imageLoader.load(POWERUP_PATH);

        entities = new ArrayList<>();
        entityFactory = new ImageEntityFactory(ship, asteroids, bullets, powerUp);
        collisionEngine = new CollisionEngine<>();
        shipController = entityFactory.createShip(MAX_WIDTH / 2, MAX_HEIGHT / 2);
        entities.add(shipController);
//        for (int i = 0; i < 10; i++) {
//            entities.add(entityFactory.createAsteroid(ThreadLocalRandom.current().nextInt(MAX_WIDTH), ThreadLocalRandom.current().nextInt(MAX_HEIGHT)));
//        }
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {

        for (Entity entity : entities) {
            System.out.println(entity.toString());
        }

        List<Entity> toDelete = new ArrayList<>();

        if (keySet.contains(38)) {
            shipController.moveForward();
        }

        if (keySet.contains(40)) {
            shipController.moveBackward();
        }

        if (keySet.contains(37)) {
            shipController.moveLeft();
        }

        if (keySet.contains(39)) {
            shipController.moveRight();
        }

        if (keySet.contains(32)) {
            BulletController bulletController = shipController.fire();
            bulletController.setView(new ImageView(bullets));
            entities.add(bulletController);
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

        randomAsteroidCreation(entities, entityFactory, MAX_WIDTH, MAX_HEIGHT);
        randomPowerUpCreation(entities, entityFactory, MAX_WIDTH, MAX_HEIGHT);

        entities.removeAll(toDelete);
    }

    private void randomPowerUpCreation(List<Entity> entities, EntityFactory entityFactory, int max_width, int max_height) {
        if (ThreadLocalRandom.current().nextInt(10) > POWERUP_PROBABILITIES) {
            Vector2 edge = createRandomEdgeVector(max_width, max_height);
            entities.add(entityFactory.createPowerUp((int) edge.getX(), (int) edge.getY()));
        }
    }

    private void randomAsteroidCreation(List<Entity> entities, EntityFactory entityFactory, int max_width, int max_height) {
        if (ThreadLocalRandom.current().nextInt(10) > ASTEROID_PROBABILITIES) {
            Vector2 edge = createRandomEdgeVector(max_width, max_height);
            entities.add(entityFactory.createAsteroid((int) edge.getX(), (int) edge.getY()));
        }
    }

    private boolean fiftyFiftyChance() {
        return ThreadLocalRandom.current().nextInt(10) > 5;
    }

    private Vector2 createRandomEdgeVector(int max_width, int max_height) {
        double random = ThreadLocalRandom.current().nextDouble(0, 1);
        System.out.println(random);
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
