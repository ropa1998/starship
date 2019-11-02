package edu.austral.starship.own.interfaces;

import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.Ship;

public interface Visitor {
    void visit(Ship ship);
    void visit(Asteroid asteroid);
    void visit(Bullet bullet);
}
