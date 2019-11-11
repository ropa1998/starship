package edu.austral.starship.own.view;

import edu.austral.starship.own.abs.View;
import processing.core.PGraphics;

public class ShipView extends View {


    @Override
    public void draw(PGraphics graphics) {
        graphics.fill(60);
        graphics.rect(getModel().getPosition().getX(), getModel().getPosition().getY(), getModel().getShape().getBounds().height, getModel().getShape().getBounds().width);
        System.out.println(this.getModel().getPoints());
    }
}
