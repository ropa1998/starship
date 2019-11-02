package edu.austral.starship.own.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Model;

import java.awt.*;
import java.util.Random;

public class Asteroid extends Model {

    Random random = new Random();

    public Asteroid() {
        super(new Rectangle(20, 30, 50, 50));
    }
}
