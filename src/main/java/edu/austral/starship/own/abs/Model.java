package edu.austral.starship.own.abs;

import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public abstract class Model {

    private Shape shape;

    private Vector2 position;

    public Model(Shape shape) {
        this.shape = shape;
        this.position = Vector2.vector(shape.getBounds().x, shape.getBounds().y);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
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

}
