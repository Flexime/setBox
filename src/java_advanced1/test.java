package java_advanced1;

public class test {
    //1 указать ошибку
    //2 - 4 класса
    //
    //

    public class  Shape {
        protected String color;
        protected Boolean filled;

        public String getColor() {
            return color;
        }

        public void setColor(String newColor) {
            color = newColor;
        }

        public void setFilled(Boolean newFilled) {
            filled = newFilled;
        }

        public boolean isFilled()
        {
            if (filled == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }


        public void setFilled(boolean filledSet) {
            filled = filledSet;
        }

        public  String toString(){

            String isNot = "";
            if(isFilled() == false){
                isNot = "not";
            }
            return "color " + color + "is " + isNot +"filled";
        }


        public Shape(){
            filled = true;
            color = "red";
        }

        public  Shape (String colorn,boolean filledn){
            filled = filledn;
            color = colorn;
        }



    }

    public  class Circle extends  Shape {
        private double radius;

        public  Circle(){
            super();
            radius =1.0;
        }


        public Circle(double radius,String color ,boolean filled){

            super(color,filled);
            this.radius = radius;
        }
        public  double getRadius (){
            return radius;
        }

        public void  setRadius (double radius){
            this.radius = radius;
        }

        public  double getArea(){

            return 2*radius*Math.PI;
        }
        public  double getPerimetr(){
            return 2*radius*Math.PI;
        }
        public  String toString(){


          return "Circle's radius: "  +radius +super.toString();
        }

        public  class Rectangle extends Shape{

            private  double width;
            private  double length;
            public  Rectangle() {
                super();
                width = 1.0;
                length = 1.0;
            }

            public Rectangle(double width,double length){
                super();
                this.width=width;
                this.length=length;

            }
            public  Rectangle(double width, double length , String color, boolean filled){

                super(color,filled);
                this.width= width;
                this.length = length;

            }

            public double getWidth(){
                return  width;
            }
            public  void  setWidth(double width){

                this.width = width;

            }
            public  double getLength() {
            return length;
            }
            public  void  setLength(){
                this.length = length;
            }

            public  double getArea(){
                return  width*length;
            }

            public  double getPerimeter(){
                return  2 * (width+length);
            }


            public String toString()
            {
                return "A Rectangle with width = " + width + "and length = " + length + super.toString();
            }


        }


        class  Square extends Rectangle{

            public Square(){
                super();
                double side=1.0;
            }
            public  Square(double side){
                super(side,side);
                side=side;

            }

            public Square(double side,String color,boolean field){

                super(side,side,color,field);
                side = side;
            }

            public  double getSide(){
                return  super.getWidth();
            }
            public  void setSide(double side){
                super.setLength();
                super.setWidth(side);

            }
            public String toString()
            {
                return "A Square with side = " + getSide()  + super.toString();
            }

        }

    }

}

