package edu.austral.starship.own.factories;

import edu.austral.starship.own.controller.AsteroidController;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.controller.PowerUpController;
import edu.austral.starship.own.controller.ShipController;
import edu.austral.starship.own.interfaces.EntityFactory;
import edu.austral.starship.own.model.weapon.DoubleDamage;
import edu.austral.starship.own.model.weapon.SlowerBullets;
import edu.austral.starship.own.visitor.PoweUpVisitor;
import processing.core.PImage;

public class ImageEntityFactory implements EntityFactory {

    private final PImage playerOneShip;
    private final PImage asteroid;
    private final PImage bullet;
    private final PImage powerUp;
    private final PImage playerTwoShip;

    public ImageEntityFactory(PImage playerOneShip, PImage playerTwoShip, PImage asteroid, PImage bullet, PImage powerUp) {
        this.playerOneShip = playerOneShip;
        this.playerTwoShip = playerTwoShip;
        this.asteroid = asteroid;
        this.bullet = bullet;
        this.powerUp = powerUp;
    }

    @Override
    public AsteroidController createAsteroid(int x, int y) {
        return new AsteroidController(x, y, asteroid);
    }

    @Override
    public ShipController createShip(int x, int y) {
        return new ShipController(x, y, playerTwoShip);
    }

    @Override
    public BulletController createBullet(int x, int y) {
        return new BulletController(x, y, bullet);
    }

    @Override
    public PowerUpController createDoubleDamagePowerUp(int x, int y) {
        return new PowerUpController(x, y, powerUp, new PoweUpVisitor(new DoubleDamage()));
    }

    @Override
    public PowerUpController createSlowerBulletsPowerUp(int x, int y) {
        return new PowerUpController(x, y, powerUp, new PoweUpVisitor(new SlowerBullets()));
    }

    @Override
    public ShipController createXwing(int x, int y) {
        return new ShipController(x, y, playerOneShip);
    }

    @Override
    public ShipController createTieFighter(int x, int y) {
        return new ShipController(x, y, playerTwoShip);
    }
}
