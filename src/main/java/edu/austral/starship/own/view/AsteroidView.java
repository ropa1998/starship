package edu.austral.starship.own.view;

import edu.austral.starship.own.abs.View;
import processing.core.PGraphics;
import processing.core.PImage;

public class AsteroidView extends View {
    @Override
    public void draw(PGraphics graphics) {
        graphics.fill(30);
        graphics.rect(getModel().getPosition().getX(), getModel().getPosition().getY(), getModel().getShape().getBounds().height, getModel().getShape().getBounds().width);
    }
}
