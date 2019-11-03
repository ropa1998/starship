package edu.austral.starship.own.controller;

import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.interfaces.Entity;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.view.AsteroidView;


public class AsteroidController extends Controller {

    public AsteroidController() {
        super(new Asteroid(), new AsteroidView());
    }


    public void move() {
        this.model.move();
    }





}
