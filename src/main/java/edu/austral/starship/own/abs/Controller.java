package edu.austral.starship.own.abs;

import edu.austral.starship.own.interfaces.ControllerVisitor;
import edu.austral.starship.own.interfaces.Entity;
import edu.austral.starship.own.interfaces.Visitor;
import processing.core.PGraphics;

import java.awt.*;

public abstract class Controller implements Entity {
    protected Model model;
    protected View view;

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

    public void pushIn(int MAX_HEIGHT, int MAX_WIDTH) {
        model.pushIn(MAX_HEIGHT, MAX_WIDTH);
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
}
