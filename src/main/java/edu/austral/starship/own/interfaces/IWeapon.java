package edu.austral.starship.own.interfaces;

import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.model.Bullet;

public interface IWeapon {

    public BulletController fire(Bullet bullet) throws Exception;
}
