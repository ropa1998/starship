package edu.austral.starship.own.controller;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.view.AsteroidView;


public class AsteroidController extends Controller {

    public AsteroidController() {
        super(new Asteroid(), new AsteroidView());
    }

    @Override
    public void collisionedWith(Collisionable collisionable) {

    }

    @Override
    public void move() {
        this.model.move();
    }


}
