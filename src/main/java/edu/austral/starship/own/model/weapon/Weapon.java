package edu.austral.starship.own.model.weapon;

import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.interfaces.IWeapon;
import edu.austral.starship.own.model.Bullet;

public class Weapon implements IWeapon {
    public BulletController fire(Bullet bullet) {
        return new BulletController(bullet);
    }
}
