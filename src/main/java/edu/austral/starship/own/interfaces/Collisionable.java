package edu.austral.starship.own.interfaces;

import java.awt.*;
import java.util.List;

public interface Collisionable {
    Shape getShape();
    void collissionedWith(List<Collisionable> collisionableList);
    Visitor getVisitor();
    void accept(Visitor visitor);
}
