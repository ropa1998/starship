package edu.austral.starship.own.interfaces;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.model.Asteroid;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.model.Ship;

public interface Visitor {
    void visit(ShipController ship);
    void visit(AsteroidController asteroid);
    void visit(BulletController bullet);
}
