package edu.austral.starship.own.visitor;

import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.PowerUp;
import edu.austral.starship.own.model.Ship;
import edu.austral.starship.own.model.weapon.DoubleDamage;

public class DoubleDamagePowerUpVisitor implements Visitor {


    @Override
    public void visit(Ship ship) {
        ship.addPowerUp(new DoubleDamage());
    }

    @Override
    public void visit(Asteroid asteroid) {

    }

    @Override
    public void visit(Bullet bullet) {

    }

    @Override
    public void visit(PowerUp powerUp) {

    }
}
