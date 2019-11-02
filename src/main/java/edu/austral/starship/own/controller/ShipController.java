package edu.austral.starship.own.controller;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.interfaces.Maneuvrable;
import edu.austral.starship.own.model.Ship;
import edu.austral.starship.own.view.ShipView;

public class ShipController extends Controller implements Maneuvrable {

    int SHIP_SPEED = 10;

    public ShipController() {
        super(new Ship(), new ShipView());
    }


    @Override
    public void collisionedWith(Collisionable collisionable) {

    }

    @Override
    public void moveForward() {
        this.model.setAppliedVector(model.getAppliedVector().add(Vector2.vector(0, -SHIP_SPEED)));
    }

    @Override
    public void moveBackward() {
        this.model.setAppliedVector(model.getAppliedVector().add(Vector2.vector(0, SHIP_SPEED)));
    }

    @Override
    public void moveLeft() {
        this.model.setAppliedVector(model.getAppliedVector().add(Vector2.vector(-SHIP_SPEED, 0)));
    }

    @Override
    public void moveRight() {
        this.model.setAppliedVector(model.getAppliedVector().add(Vector2.vector(SHIP_SPEED, 0)));
    }

    @Override
    public void move() {
        this.model.move();
        this.model.setAppliedVector(this.model.getAppliedVector().multiply((float) 0.4));
    }
}
