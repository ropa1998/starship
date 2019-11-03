package edu.austral.starship.own.factories;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.interfaces.EntityFactory;

public class BasicEntityFactory implements EntityFactory {

    @Override
    public AsteroidController createAsteroid() {
        return new AsteroidController();
    }

    @Override
    public ShipController createShip() {
        return new ShipController();
    }

    @Override
    public BulletController createBullet() {
        return null;
    }

}
