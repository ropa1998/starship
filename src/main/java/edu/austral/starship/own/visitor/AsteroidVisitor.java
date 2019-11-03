package edu.austral.starship.own.visitor;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.Ship;

public class AsteroidVisitor implements Visitor {
    @Override
    public void visit(ShipController ship) {

    }

    @Override
    public void visit(AsteroidController asteroid) {

    }

    @Override
    public void visit(BulletController bullet) {

    }

    @Override
    public void visit(Ship ship) {
        System.out.println("Visited a ship controller as an asteroid controller");
    }

    @Override
    public void visit(Asteroid asteroid) {

    }

    @Override
    public void visit(Bullet bullet) {

    }
}
