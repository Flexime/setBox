package java_advanced1.GeometricObj;

public  class ResizableCircle extends Circle implements Resizable {

    private final double radius;

    // Constructor
    public ResizableCircle(double radius) {
        super();
        this.radius=radius;
    }

    public String toString(){
        return ( "radius: " +radius);
    }
    @Override
    public double resize(int percent) {
        return radius*percent;
    }
}