package edu.austral.starship.own.interfaces;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.PowerUpController;
import edu.austral.starship.own.controller.ShipController;

public interface EntityFactory {
    AsteroidController createAsteroid(int x, int y);

    ShipController createShip(int x, int y);

    BulletController createBullet(int x, int y);

    PowerUpController createPowerUp(int x, int y);
}
