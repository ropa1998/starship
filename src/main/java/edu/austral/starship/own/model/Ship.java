package edu.austral.starship.own.model;

import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.interfaces.IWeapon;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.model.weapon.Weapon;
import edu.austral.starship.own.model.weapon.WeaponDecorator;
import edu.austral.starship.own.visitor.ShipVisitor;

import java.awt.*;

public class Ship extends Model {

    public int lives = 5;
    IWeapon weapon;

    public Ship(int x, int y) {
        this.setVisitor(new ShipVisitor());
        this.setShape(new Rectangle(x, y, 50, 50));
        this.weapon = new Weapon();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAlive() {
        return lives > 0;
    }

    @Override
    public void damage() {
        this.lives -= 1;
    }

    @Override
    public BulletController fire() throws Exception {
        Bullet bullet = new Bullet((int) this.getPosition().getX(), (int) this.getPosition().getY());
        return weapon.fire(bullet);
    }

    public void addPowerUp(WeaponDecorator powerUp) {
        powerUp.setNextWeapon(weapon);
        this.weapon = powerUp;
    }
}
