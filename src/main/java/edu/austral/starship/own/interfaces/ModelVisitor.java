package edu.austral.starship.own.interfaces;

import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.PowerUp;
import edu.austral.starship.own.model.Ship;

public interface ModelVisitor {
    void visit(Ship ship);

    void visit(Asteroid asteroid);

    void visit(Bullet bullet);

    void visit(PowerUp powerUp);
}
