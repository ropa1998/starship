package edu.austral.starship.own.visitor;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.Ship;

public class ShipVisitor implements Visitor {

    @Override
    public void visit(ShipController ship) {

    }

    @Override
    public void visit(AsteroidController asteroid) {

    }

    @Override
    public void visit(BulletController bullet) {

    }
}
