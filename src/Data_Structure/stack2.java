package Data_Structure;

import java.util.Stack;

public class stack2 {

  static void  firstANDsecondIsEmpty(Stack  first,Stack second){
    boolean b1;
    boolean b2;

    if (first.isEmpty()){
        b1 = true;
    };
    if (second.isEmpty() ){
      b2 = true;
    }

    showpop(first);
    showpop(second);
  }


  static void   XOR(Stack first,Stack second) {
     boolean b1 = true;
     boolean b2 = true;

    b1 &= b2;
    b1|= b2;
    b1^= b2;
  }

  static void showpop(Stack s ) {

    System.out.println("Data_Structure.stack" +s);
  }
  public static void main(String[] args) {


    Stack first = new Stack();
    Stack second = new Stack();

    first.push(34);
    first.push(2);
    first.push(113);
    first.push(5);

    second.push(313);
    second.push(32);
    second.push(7);
    second.push(81);

    firstANDsecondIsEmpty(first,second);
    XOR(first,second);

    // Print stacks using “show” function you wrote
        showpop(first);
        showpop(second);
    //Write down code to swap elements of stacks

    //For exapmple, 1-st element of first Data_Structure.stack replaces with 1-st element of second Data_Structure.stack

    //Print swapped stacks using “show” function you wrote

    showpop(first);
    showpop(second);



  }

}
