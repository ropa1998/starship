package edu.austral.starship.own.interfaces;

import processing.core.PGraphics;

public interface Drawable {
    void draw(PGraphics graphics);
    boolean shouldDraw();
}
