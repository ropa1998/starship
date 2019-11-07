package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.factories.BasicEntityFactory;
import edu.austral.starship.own.interfaces.Entity;
import edu.austral.starship.own.interfaces.EntityFactory;
import processing.core.PGraphics;
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

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .setSize(MAX_WIDTH, MAX_HEIGHT);
        entities = new ArrayList<>();
        entityFactory = new BasicEntityFactory();
        collisionEngine = new CollisionEngine<>();
        shipController = entityFactory.createShip(MAX_WIDTH / 2, MAX_HEIGHT / 2);
        entities.add(shipController);
        for (int i = 0; i < 10; i++) {
            entities.add(entityFactory.createAsteroid(ThreadLocalRandom.current().nextInt(MAX_WIDTH), ThreadLocalRandom.current().nextInt(MAX_HEIGHT)));
        }
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
            entities.add(entityFactory.createBullet((int) shipController.getShape().getBounds().getCenterX(), (int) shipController.getShape().getBounds().getY()));
        }

        collisionEngine.checkCollisions(entities);

        graphics.background(80);


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

        entities.removeAll(toDelete);
    }

    private void randomAsteroidCreation(List<Entity> entities, EntityFactory entityFactory, int max_width, int max_height) {
        if (ThreadLocalRandom.current().nextInt(10) > 8) {
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
