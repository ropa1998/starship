package edu.austral.starship.own.model.weapon;

import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.model.Bullet;

public class SlowerBullets extends WeaponDecorator {
    @Override
    public BulletController fire(Bullet bullet) {
        bullet.appliedVector = bullet.appliedVector.multiply(.5f);
        return this.nextWeapon.fire(bullet);
    }
}
