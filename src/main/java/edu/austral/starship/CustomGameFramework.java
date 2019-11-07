package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
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

        entities.removeAll(toDelete);
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
