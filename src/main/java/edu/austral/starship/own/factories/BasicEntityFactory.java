package edu.austral.starship.own.factories;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.PowerUpController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.interfaces.EntityFactory;

public class BasicEntityFactory implements EntityFactory {


    @Override
    public AsteroidController createAsteroid(int x, int y) {
        return new AsteroidController(x, y);
    }

    @Override
    public ShipController createShip(int x, int y) {
        return new ShipController(x, y);
    }

    @Override
    public BulletController createBullet(int x, int y) {
        return new BulletController(x, y);
    }

    @Override
    public PowerUpController createPowerUp(int x, int y) {
        return null;
    }
}
