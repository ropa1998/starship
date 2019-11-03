package edu.austral.starship.own.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.visitor.AsteroidVisitor;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Asteroid extends Model {

    private Random random = new Random();

    public Asteroid() {
        this.setVisitor(new AsteroidVisitor());
        int x = random.nextInt(500);
        int y = random.nextInt(500);
        this.setShape(new Rectangle(x, y, 50, 50));
        int vectorX = ThreadLocalRandom.current().nextInt(-2, 2);
        int vectorY = ThreadLocalRandom.current().nextInt(-2, 2);
        this.setAppliedVector(Vector2.vector(vectorX, vectorY));
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
