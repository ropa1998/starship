package edu.austral.starship.own.model;

import edu.austral.starship.own.controller.BulletController;

public class Weapon {
    BulletController fire(float x, float y) {
        return new BulletController((int) x, (int) y);
    }
}
