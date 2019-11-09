package edu.austral.starship.own.controller;

import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.model.PowerUp;
import edu.austral.starship.own.view.ImageView;
import processing.core.PImage;

public class PowerUpController extends Controller {


    public PowerUpController(int x, int y, PImage powerUp) {
        super(new PowerUp(x, y), new ImageView(powerUp));
    }

    @Override
    public void offFrame() {
        this.model.damage();
    }

    @Override
    public void damage() {
        this.model.damage();
    }

    @Override
    public void move() {
        this.model.move();
    }
}
