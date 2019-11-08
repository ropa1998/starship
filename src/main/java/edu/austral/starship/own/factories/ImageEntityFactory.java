package edu.austral.starship.own.factories;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.interfaces.EntityFactory;
import processing.core.PImage;

public class ImageEntityFactory implements EntityFactory {

    private final PImage ship;
    private final PImage asteroid;
    private final PImage bullet;

    public ImageEntityFactory(PImage ship, PImage asteroid, PImage bullet) {
        this.ship = ship;
        this.asteroid = asteroid;
        this.bullet = bullet;
    }

    @Override
    public AsteroidController createAsteroid(int x, int y) {
        return new AsteroidController(x, y, asteroid);
    }

    @Override
    public ShipController createShip(int x, int y) {
        return new ShipController(x, y, ship);
    }

    @Override
    public BulletController createBullet(int x, int y) {
        return new BulletController(x, y, bullet);
    }
}
