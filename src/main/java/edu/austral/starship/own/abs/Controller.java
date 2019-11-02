package edu.austral.starship.own.abs;

import edu.austral.starship.own.interfaces.Entity;
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

    public Shape getShape(){
        return model.getShape();
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void draw(PGraphics graphics){
        view.draw(graphics);
    }


}
