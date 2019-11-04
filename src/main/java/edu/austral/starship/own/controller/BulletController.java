package edu.austral.starship.own.controller;

import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.view.BulletView;

public class BulletController extends Controller {

    private int SHIP_SPEED = 10;

    public BulletController(int x, int y) {
        super(new Bullet(x, y), new BulletView());
    }

    @Override
    public void move() {
        this.model.move();
    }
}
