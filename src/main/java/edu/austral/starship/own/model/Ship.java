package edu.austral.starship.own.model;

import edu.austral.starship.own.abs.Model;

import java.awt.*;

public class Ship extends Model {

    public Ship() {
        this.setShape(new Rectangle(20, 30, 50, 50));
    }
}