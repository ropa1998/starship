package edu.austral.starship.own.visitor;

import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.Ship;

public class BulletVisitor implements Visitor {
    @Override
    public void visit(Ship ship) {

    }

    @Override
    public void visit(Asteroid asteroid) {
        asteroid.alive = false;
    }

    @Override
    public void visit(Bullet bullet) {

    }
}
