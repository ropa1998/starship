package edu.austral.starship.own.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.controller.BulletController;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.visitor.BulletVisitor;

import java.awt.*;

public class Bullet extends Model {

    public int lives = 1;

    public Bullet(int x, int y) {

        this.setVisitor(new BulletVisitor());
        this.setShape(new Rectangle(x, y, 10, 10));
        this.setAppliedVector(Vector2.vector(0, -5));
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAlive() {
        return lives != 0;
    }

    @Override
    public void damage() {
        this.lives -= 1;
    }

    @Override
    public BulletController fire() {
        return null;
    }


}
