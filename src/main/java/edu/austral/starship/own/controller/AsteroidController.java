package edu.austral.starship.own.controller;

import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.view.AsteroidView;
import edu.austral.starship.own.view.ImageView;
import processing.core.PImage;


public class AsteroidController extends Controller {

    public AsteroidController(int x, int y) {
        super(new Asteroid(x, y), new AsteroidView());
    }

    public AsteroidController(int x, int y, PImage asteroid) {
        super(new Asteroid(x, y), new ImageView(asteroid));
    }


    public void move() {
        this.model.move();
    }


    @Override
    public void offFrame() {
        this.model.damage();
    }

    @Override
    public void damage() {
        this.model.damage();
    }
}
