package edu.austral.starship.own.controller;

import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.interfaces.Entity;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.view.AsteroidView;


public class AsteroidController extends Controller {

    public AsteroidController() {
        super(new Asteroid(), new AsteroidView());
    }


    @Override
    public void move() {
        this.model.move();
    }


    @Override
    public void collisionedWith(Entity collisionable) {

    }

    @Override
    public Visitor getVisitor() {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
