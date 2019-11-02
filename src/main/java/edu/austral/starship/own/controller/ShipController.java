package edu.austral.starship.own.controller;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.interfaces.Maneuvrable;
import edu.austral.starship.own.model.Ship;
import edu.austral.starship.own.view.ShipView;

public class ShipController extends Controller implements Maneuvrable {

    public ShipController() {
        super(new Ship(), new ShipView());
    }


    @Override
    public void collisionedWith(Collisionable collisionable) {

    }

    @Override
    public void moveForward() {
        this.model.setAppliedVector(Vector2.vector(0,-10));
    }

    @Override
    public void moveBackward() {
        this.model.setAppliedVector(Vector2.vector(0,10));
    }

    @Override
    public void moveLeft() {
        this.model.setAppliedVector(Vector2.vector(-10, 0));
    }

    @Override
    public void moveRight() {
        this.model.setAppliedVector(Vector2.vector(10, 0));
    }

    @Override
    public void move() {
        this.model.move();
        this.model.setAppliedVector(this.model.getAppliedVector().multiply((float) 0.9));
    }
}
