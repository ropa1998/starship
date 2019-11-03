package edu.austral.starship.own.interfaces;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.ShipController;

public interface EntityFactory {
    AsteroidController createAsteroid();

    ShipController createShip();

    BulletController createBullet();
}
