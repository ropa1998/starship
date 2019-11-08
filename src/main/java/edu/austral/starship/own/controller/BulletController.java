package edu.austral.starship.own.controller;

import edu.austral.starship.own.abs.Controller;
import edu.austral.starship.own.model.Bullet;
import edu.austral.starship.own.view.BulletView;
import edu.austral.starship.own.view.ImageView;
import processing.core.PImage;

public class BulletController extends Controller {

    private int SHIP_SPEED = 10;

    public BulletController(int x, int y) {
        super(new Bullet(x, y), new BulletView());
    }

    public BulletController(int x, int y, PImage bullet) {
        super(new Bullet(x, y), new ImageView(bullet));
    }

    @Override
    public void move() {
        this.model.move();
    }


    @Override
    public void offFrame() {
        this.model.damage();
    }

    @Override
    public void damage() {
        this.model.damage();
    }
}
