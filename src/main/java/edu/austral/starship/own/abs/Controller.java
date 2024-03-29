package edu.austral.starship.own.abs;

import edu.austral.starship.own.interfaces.Entity;
import edu.austral.starship.own.interfaces.Visitor;
import processing.core.PGraphics;

import java.awt.*;

public abstract class Controller implements Entity {
    public Model model;
    public View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setModel(model);
    }


    public Shape getShape() {
        return model.getShape();
    }

    public void draw(PGraphics graphics) {
        view.draw(graphics);
    }

    public boolean isInsideScreen(int max_height, int max_width) {
        return model.isInsideScreen(max_height, max_width);
    }


    public Visitor getVisitor() {
        return model.getVisitor();
    }

    public void accept(Visitor visitor) {
        model.accept(visitor);
    }

    public void collisionedWith(Entity collisionable) {
        collisionable.accept(this.getVisitor());
    }

    @Override
    public boolean shouldDraw() {
        return model.isAlive();
    }

    @Override
    public boolean isAlive() {
        return model.isAlive();
    }

    public abstract void offFrame();


    public void setView(View view) {
        view.setModel(this.model);
        this.view = view;
    }
}
