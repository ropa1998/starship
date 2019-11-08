package edu.austral.starship.own.view;

import edu.austral.starship.own.abs.View;
import processing.core.PGraphics;
import processing.core.PImage;

public class ImageView extends View {

    private final PImage image;

    public ImageView(PImage image) {
        this.image = image;
    }

    @Override
    public void draw(PGraphics graphics) {
//        graphics.rect(getModel().getPosition().getX(), getModel().getPosition().getY(), getModel().getShape().getBounds().height, getModel().getShape().getBounds().width);
        graphics.image(image, this.getModel().position.getX(), this.getModel().position.getY());
    }

}
