package edu.austral.starship.own.abs;

import processing.core.PGraphics;

public abstract class View {
    private Model model;
    public abstract void draw(PGraphics graphics);

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}
