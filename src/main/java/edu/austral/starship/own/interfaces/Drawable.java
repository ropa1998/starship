package edu.austral.starship.own.interfaces;

import processing.core.PGraphics;

public interface Drawable {
    void draw(PGraphics graphics);

    boolean shouldDraw();

    boolean isInsideScreen(int max_height, int max_width);

    void offFrame();
}
