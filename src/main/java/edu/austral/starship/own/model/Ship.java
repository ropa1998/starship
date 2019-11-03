package edu.austral.starship.own.model;

import edu.austral.starship.own.abs.Model;
import edu.austral.starship.own.interfaces.Visitor;
import edu.austral.starship.own.visitor.ShipVisitor;

import java.awt.*;

public class Ship extends Model {

    public int lives = 5;

    public Ship() {
        this.setVisitor(new ShipVisitor());
        this.setShape(new Rectangle(20, 30, 50, 50));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAlive() {
        return lives > 0;
    }
}
