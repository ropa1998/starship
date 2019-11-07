package edu.austral.starship.own.abs;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.interfaces.Visitor;

import java.awt.*;

public abstract class Model {

    private Shape shape;

    public Vector2 position;

    public Vector2 appliedVector = Vector2.vector(0, 0);

    private Visitor visitor;

    private boolean alive;

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

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public abstract void accept(Visitor visitor);

    public abstract boolean isAlive();

    public abstract void damage();

    //TODO feardo esto, hay que arreglarlo de alguna manera.
    public abstract BulletController fire();
}
