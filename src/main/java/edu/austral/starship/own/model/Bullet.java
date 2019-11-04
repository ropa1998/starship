package edu.austral.starship.own.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.visitor.BulletVisitor;

import java.awt.*;

public class Bullet extends Model {

    boolean alive;

    public Bullet(int x, int y) {
        alive = true;
        this.setVisitor(new BulletVisitor());
        this.setShape(new Rectangle(x, y, 10, 10));
        this.setAppliedVector(Vector2.vector(0, -2));
    }

    @Override
    public void pushIn(int MAX_HEIGHT, int MAX_WIDTH) {
        alive = false;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAlive() {
        return alive;
    }
}
