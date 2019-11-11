package edu.austral.starship.own.visitor;

import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.PowerUp;
import edu.austral.starship.own.model.Ship;

public class BulletVisitor implements Visitor {


    private final Ship ship;

    public BulletVisitor(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void visit(Ship ship) {

    }

    @Override
    public void visit(Asteroid asteroid) {
        asteroid.alive = false;
        ship.addPoints(100);
    }

    @Override
    public void visit(Bullet bullet) {

    }

    @Override
    public void visit(PowerUp powerUp) {

    }
}
