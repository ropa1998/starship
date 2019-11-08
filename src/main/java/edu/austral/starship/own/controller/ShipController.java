package edu.austral.starship.own.controller;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.interfaces.IShip;
import edu.austral.starship.own.interfaces.Maneuvrable;
import edu.austral.starship.own.model.Ship;
import edu.austral.starship.own.view.ImageView;
import edu.austral.starship.own.view.ShipView;
import processing.core.PImage;

public class ShipController extends Controller implements Maneuvrable, IShip {

    private int SHIP_SPEED = 10;

    public ShipController(int x, int y) {
        super(new Ship(x, y), new ShipView());
    }

    public ShipController(int x, int y, PImage ship) {
        super(new Ship(x, y), new ImageView(ship));
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


    @Override
    public void offFrame() {
        this.model.appliedVector = this.model.appliedVector.multiply(-2f);
    }

    @Override
    public void damage() {
        this.model.damage();
    }

    @Override
    public BulletController fire() {
        return this.model.fire();
    }
}
