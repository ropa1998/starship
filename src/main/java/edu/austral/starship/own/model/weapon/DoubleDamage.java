package edu.austral.starship.own.model.weapon;

import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.model.Bullet;

public class DoubleDamage extends WeaponDecorator {


    @Override
    public BulletController fire(Bullet bullet) {
        bullet.lives = bullet.lives * 2;
        return this.nextWeapon.fire(bullet);
    }
}
