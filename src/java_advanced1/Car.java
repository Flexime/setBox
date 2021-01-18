package java_advanced1;

import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

class Car {

    String name;
    int move;

    public Car() {
        name = "";
        move = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    @Override
    public String toString() {

        return (this.getName() + " " + this.getMove());
    }


    public static void main(String[] args) throws Exception  {
        Stack<Car> stack2 = new Stack<>();
        Stack<Car> stack2BUFFER = new Stack<>();


        String path = "C:\\Users\\DELEHA\\IdeaProjects\\setBox\\src\\java_advanced1\\Input.txt";
        FileReader fr = new FileReader(path);
        Scanner sc = new Scanner(fr);

        String[] arrList = new String[15];

        String name = "";
        String io = "";

        String[] cars = new String[15];
        for (int i = 0; sc.hasNextLine(); i++) {


            cars[i] = sc.nextLine();
        }
                for (int i =0; i < 15; i++) {
                    String[] line = new String[arrList.length];

                    line = cars[i].split(" ");

                    Car car = new Car();
                    car.setName(line[0]);
                    System.out.println("\n" + line[0] + "   " + line[1]  );


                     if (line[1].equals("in")) {
                         if (stack2.size() <5 ){

                             stack2.push(car);
                             // stack2.peek().setMove(stack2.peek().getMove() + 1);
                             // System.out.println(stack2.peek().getName() + " moved " + stack2.peek().getMove() + " times");
                             System.out.println("Parking:  "+ stack2 );
                         }else System.out.println("=====================not enough space==============================");


                    }
                    else  if (line[1].equals("out")  ) {
                        while (!car.name.equals(stack2.peek().getName())) {
                            stack2.peek().setMove(stack2.peek().getMove() + 1);
                            stack2BUFFER.push(stack2.peek());
                            stack2.pop();
                        }

                        if(!stack2.empty()){
                            if(car.name.equals(stack2.peek().getName())){
                                System.out.println(stack2.peek().getName() + " moved " + stack2.peek().getMove() + " times");
                                stack2.pop();
                            }

                        }
                            while (!stack2BUFFER.empty()){

                                stack2.push(stack2BUFFER.peek());
                                stack2BUFFER.pop();
                            }
                         System.out.println("Parking: " + stack2);

 }




                    //System.out.println( car.toString() );

                    System.out.println(stack2 );
                    }



            if (stack2.isEmpty()){
                System.out.println("no one on parking");
            }else System.out.println( stack2.peek().getName() + " is on Parking");





        fr.close();
                }





            }
