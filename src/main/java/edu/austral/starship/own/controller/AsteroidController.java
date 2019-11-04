package edu.austral.starship.own.controller;

import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.view.AsteroidView;


public class AsteroidController extends Controller {

    public AsteroidController(int x, int y) {
        super(new Asteroid(x, y), new AsteroidView());
    }


    public void move() {
        this.model.move();
    }


}
