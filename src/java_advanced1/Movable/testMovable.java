package java_advanced1.Movable;

        import java_advanced1.Movable.Movable;
        import java_advanced1.Movable.MovableCircle;
        import java_advanced1.Movable.MovablePoint;

public class testMovable {
    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 10, 15);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);
    }
}
