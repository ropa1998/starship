package edu.austral.starship.own.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.visitor.ShipVisitor;

import java.awt.*;

public class Ship extends Model {

    public int lives = 5;

    public Ship(int x, int y) {
        this.setVisitor(new ShipVisitor());
        this.setShape(new Rectangle(x, y, 50, 50));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAlive() {
        return lives > 0;
    }

    public void pushIn(int MAX_HEIGHT, int MAX_WIDTH) {
        boolean left = position.getX() < 0;
        boolean right = position.getX() > MAX_WIDTH - 100;
        boolean up = position.getY() < 0;
        boolean down = position.getY() > MAX_HEIGHT - 100;

        Vector2 result = Vector2.vector(0, 0);

        if (left) {
            result = result.add(Vector2.vector(1, 0));
        }
        if (right) {
            result = result.add(Vector2.vector(-1, 0));
        }
        if (up) {
            result = result.add(Vector2.vector(0, 1));
        }
        if (down) {
            result = result.add(Vector2.vector(0, -1));
        }

        appliedVector = result;
    }
}
