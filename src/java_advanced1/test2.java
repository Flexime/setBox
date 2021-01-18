package java_advanced1;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;
public class test2 {



        public static void main(String[] args) throws Exception  {

            Stack<Car> stack = new Stack<>();
            Stack<Car> extra = new Stack<>();


            String path = "C:\\Users\\DELEHA\\IdeaProjects\\setBox\\src\\java_advanced1\\Input.txt";;
            FileReader file = new FileReader(path);
            Scanner sc = new Scanner(file);
            String[] cars = new String[15];


            for (int i = 0; sc.hasNextLine(); i++) {
                cars[i] = sc.nextLine();
            }
            for (int i =0; i < 15; i++) {
                String[] line;

                line = cars[i].split(" ");

                Car car = new Car();
                car.setName(line[0]);


                if (line[1].equals("in")) {
                    if(stack.size() <= 5){
                        System.out.println(line[0] + " parked");
                        stack.push(car);
                        System.out.println("Parking "+ stack + "\n");
                    }
                    else{
                        System.out.println("Parking is full");
                    }
                }
                else  if (line[1].equals("out")) {


                    while (!car.name.equals(stack.peek().getName())) {
                        stack.peek().setMove(stack.peek().getMove() + 1);
                        extra.push(stack.peek());
                        stack.pop();
                    }

                    if(!stack.empty()){
                        System.out.println(stack.peek().getName() + " left the parking \n"  + stack.peek().getName() + " was moved " + stack.peek().getMove() + " times");
                        stack.pop();

                    }
                    while (!extra.empty()){
                        stack.push(extra.peek());
                        extra.pop();
                    }

                    System.out.println("Parking " + stack + "\n");


                }



            }
            file.close();
        }

        String name;
        int move;

        public test2() {
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
    }

