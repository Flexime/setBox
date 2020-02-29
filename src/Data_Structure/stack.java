package Data_Structure;

import java.util.Stack;

public class stack {

  static void showpush(Stack s) {
    while (s.empty()){
      s.push(s);
      showpop(s);
    }

  }

  static void showpop(Stack s ) {
    System.out.println("pop-> ");
      double a = (Double)s.pop();
    System.out.println(a);
    System.out.println("Data_Structure.stack" +s);
  }
  public static void main(String[] args) {



    Stack s = new Stack(); //create doubles Data_Structure.stack and fill it with double varibales
    s.push(3.14);
    s.push(1.667);
    s.push(9.8);
    s.push(6.02);

    System.out.println("The Data_Structure.stack is : " + s ); //call show function written above

    System.out.println("Size of Data_Structure.stack : "+s.size());//show size of Data_Structure.stack(amount of elements)
    System.out.println("Last element of Data_Structure.stack : " +s.peek());  //show last element(first inputted element)
    System.out.println("Delete last element: ");
    showpop(s); //Delete last element
    //call function to delete last element
    showpush(s);
    //call show function again to see Data_Structure.stack without deleted element
    if (s.empty()){
      System.out.println("Data_Structure.stack is empty");
    }else {
      System.out.println("Data_Structure.stack is not empty");
    }


  }
}