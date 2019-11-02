package edu.austral.starship;

import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.model.Asteroid;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.Set;

public class CustomGameFramework implements GameFramework {

    //    List<Entity> entities = new ArrayList<>();
    ShipController shipController;

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .setSize(500, 500);
        shipController = new ShipController();
        for (int i = 0; i < 3; i++) {
            Controller controller = new Asteroid
        }
//        entities.add(shipController);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        if (keySet.contains(38)) {
            System.out.println("moving forward");
            shipController.moveForward();
        }

        if (keySet.contains(40)) {
            System.out.println("moving backwards");
            shipController.moveBackward();
        }

        if (keySet.contains(37)) {
            System.out.println("rotating left");
            shipController.moveLeft();
        }

        if (keySet.contains(39)) {
            System.out.println("rotating right");
            shipController.moveRight();
        }


        graphics.background(80);
//        for (Entity entity : entities) {
//            entity.draw(graphics);
//        }
//        graphics.rect(30, 60, 30,50);
        shipController.draw(graphics);
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
