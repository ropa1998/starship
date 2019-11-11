package edu.austral.starship.own.model.weapon;

import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.interfaces.IWeapon;
import edu.austral.starship.own.model.Bullet;

import java.time.Duration;
import java.time.Instant;

public class Weapon implements IWeapon {

    private Instant lastShot;

    public Weapon() {
        this.lastShot = Instant.now();
    }

    public BulletController fire(Bullet bullet) throws Exception {
        if (Duration.between(lastShot, Instant.now()).toMillis() >= 250) {
            lastShot = Instant.now();
            return new BulletController(bullet);
        }
        throw new Exception("You cannot fire. The weapon is cooling down!");
    }
}
