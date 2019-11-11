package edu.austral.starship.own.model.weapon;

import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.interfaces.IWeapon;
import edu.austral.starship.own.model.Bullet;

public abstract class WeaponDecorator implements IWeapon {

    IWeapon nextWeapon;

    @Override
    public abstract BulletController fire(Bullet bullet) throws Exception;

    public void setNextWeapon(IWeapon nextWeapon) {
        this.nextWeapon = nextWeapon;
    }
}
