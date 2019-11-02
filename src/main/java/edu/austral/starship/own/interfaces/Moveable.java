package edu.austral.starship.own.interfaces;

public interface Moveable {
    void move();

    boolean isInsideScreen(int max_height, int max_width);

    void pushIn(int MAX_HEIGHT, int MAX_WIDTH);
}
