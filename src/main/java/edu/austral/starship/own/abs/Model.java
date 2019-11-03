package edu.austral.starship.own.abs;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.interfaces.Visitor;

import java.awt.*;

public abstract class Model {

    private Shape shape;

    private Vector2 position;

    private Vector2 appliedVector = Vector2.vector(0, 0);

    private Visitor visitor;

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
        Vector2 newPosition = position.add(appliedVector);
        this.setShape(new Rectangle((int) newPosition.getX(), (int) newPosition.getY(), this.getShape().getBounds().width, this.getShape().getBounds().height));
        this.setPosition(newPosition);
    }

    public Vector2 getAppliedVector() {
        return appliedVector;
    }

    public void setAppliedVector(Vector2 appliedVector) {
        this.appliedVector = appliedVector;
    }

    public boolean isInsideScreen(int max_height, int max_width) {
        return position.getX() > max_width || position.getX() < 0 || position.getY() > max_height || position.getY() < 0;
    }

    public void pushIn(int MAX_HEIGHT, int MAX_WIDTH) {
        boolean left = position.getX() < 0;
        boolean right = position.getX() > MAX_WIDTH - 100;
        boolean up = position.getY() < 0;
        boolean down = position.getY() > MAX_HEIGHT - 100;

        Vector2 result = Vector2.vector(0, 0);

        if (left) {
            result = result.add(Vector2.vector(1, 0));
        }
        if (right) {
            result = result.add(Vector2.vector(-1, 0));
        }
        if (up) {
            result = result.add(Vector2.vector(0, 1));
        }
        if (down) {
            result = result.add(Vector2.vector(0, -1));
        }

        appliedVector = result;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public abstract void accept(Visitor visitor);
}
