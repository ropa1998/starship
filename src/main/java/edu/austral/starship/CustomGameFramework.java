package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.interfaces.Entity;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomGameFramework implements GameFramework {

    private List<Entity> entities;
    private ShipController shipController;
    private CollisionEngine<Entity> collisionEngine;
    private int MAX_WIDTH = 1000;
    private int MAX_HEIGHT = 1000;

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .setSize(MAX_WIDTH, MAX_HEIGHT);
        entities = new ArrayList<>();
        collisionEngine = new CollisionEngine<Entity>();
        shipController = new ShipController();
        entities.add(shipController);
        for (int i = 0; i < 3; i++) {
            Entity entity = new AsteroidController();
            entities.add(entity);
        }
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
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

        collisionEngine.checkCollisions(entities);

        graphics.background(80);


        for (Entity entity : entities) {
            if (entity.isInsideScreen(MAX_HEIGHT, MAX_WIDTH)) {
                entity.pushIn(MAX_HEIGHT, MAX_WIDTH);
            }
            entity.move();
            entity.draw(graphics);
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
