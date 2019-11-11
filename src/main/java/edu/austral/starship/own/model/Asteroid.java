package edu.austral.starship.own.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.controller.BulletController;
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
        Vector2 vector2 = getNot0Vector();
        this.setAppliedVector(Vector2.vector(vector2.getX(), vector2.getY()));
    }

    private Vector2 getNot0Vector() {
        int vectorX = 0;
        int vectorY = 0;
        while (vectorX + vectorY == 0) {
            vectorX = ThreadLocalRandom.current().nextInt(-2, 2);
            vectorY = ThreadLocalRandom.current().nextInt(-2, 2);
        }
        return Vector2.vector(vectorX, vectorY);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void damage() {
        this.alive = false;
    }

    @Override
    public BulletController fire() {
        return null;
    }

    @Override
    public int getPoints() {
        return 0;
    }
}
