package edu.austral.starship.own.controller;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.abs.View;
import edu.austral.starship.own.interfaces.Entity;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.view.AsteroidView;
import processing.core.PGraphics;

import java.awt.*;


public class AsteroidController extends Controller {

    public AsteroidController() {
        super(new Asteroid(), new AsteroidView());
    }

    @Override
    public void collisionedWith(Collisionable collisionable) {

    }
}
