package edu.austral.starship.own.interfaces;

public interface Moveable {
    void move();

    boolean isInsideScreen(int max_height, int max_width);

    void pushIn();
}
