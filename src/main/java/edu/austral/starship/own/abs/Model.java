package edu.austral.starship.own.abs;

import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public abstract class Model {

    private Shape shape;

    private Vector2 position;

    private Vector2 appliedVector = Vector2.vector(0,0);

    public void setShape(Shape shape) {
        this.shape = shape;
        this.position = Vector2.vector(shape.getBounds().x, shape.getBounds().y);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Shape getShape() {
        return shape;
    }

    public void move() {
        this.setPosition(position.add(appliedVector));
    }

    public Vector2 getAppliedVector() {
        return appliedVector;
    }

    public void setAppliedVector(Vector2 appliedVector) {
        this.appliedVector = appliedVector;
    }
}
