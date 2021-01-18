package java_advanced1.Movable;

import java_advanced1.Movable.Movable;

public class MovablePoint implements Movable { // saved as "MovablePoint.java"
    public int x;
    public int y;
    public int xspeed;
    public int yspeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;

    }


    // Implement abstract methods declared in the interface Movable
    @Override
    public void moveUp() {
        System.out.println("Move up");
        y -= yspeed;
    }
    @Override
    public void moveDown() {
        System.out.println("Move down");

    }
    @Override
    public void moveLeft() {
        System.out.println("Move left");
        x -= xspeed;
    }
    @Override
    public void moveRight() {
        System.out.println("Move right");
        x += xspeed;
    }
}
