package edu.austral.starship.base.collision;

import edu.austral.starship.own.interfaces.Visitor;

import java.awt.*;

public interface Collisionable<T extends Collisionable<T>> {
    Shape getShape();

    void collisionedWith(T collisionable);

    Visitor getVisitor();

    void accept(Visitor visitor);
}
