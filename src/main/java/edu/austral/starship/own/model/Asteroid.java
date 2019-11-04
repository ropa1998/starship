package edu.austral.starship.own.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.visitor.AsteroidVisitor;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Asteroid extends Model {

    public boolean alive;
    private Random random = new Random();

    public Asteroid(int x, int y) {
        alive = true;
        this.setVisitor(new AsteroidVisitor());
        this.setShape(new Rectangle(x, y, 50, 50));
        int vectorX = ThreadLocalRandom.current().nextInt(-2, 2);
        int vectorY = ThreadLocalRandom.current().nextInt(-2, 2);
        this.setAppliedVector(Vector2.vector(vectorX, vectorY));
    }


    @Override
    public void pushIn(int MAX_HEIGHT, int MAX_WIDTH) {
        boolean left = this.position.getX() < 0;
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

        this.appliedVector = result;
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
