package edu.austral.starship.own.visitor;

import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.PowerUp;
import edu.austral.starship.own.model.Ship;

public class ShipVisitor implements Visitor {


    @Override
    public void visit(Ship ship) {

    }

    @Override
    public void visit(Asteroid asteroid) {
        asteroid.setAppliedVector(asteroid.getAppliedVector().multiply(-1.0f));
    }

    @Override
    public void visit(Bullet bullet) {
        bullet.damage();
    }

    @Override
    public void visit(PowerUp powerUp) {
        powerUp.damage();
    }
}
