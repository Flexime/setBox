package java_advanced1.GeometricObj;

public class Circle implements GeometricObject {
    // Private variable
        private double radius = 1.0;

    // Constructor
    public Circle() {

    }

    // Implement methods defined in the interface GeometricObject
    @Override
    public void getPerimeter() {
        System.out.println("Perimeter: " + 2*Math.PI*radius);

    }

   @Override
    public  void getArea(){
       System.out.println("Area: " + Math.PI*(radius*radius));
   }
}