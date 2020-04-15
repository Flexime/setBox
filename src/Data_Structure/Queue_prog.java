package Data_Structure;

import java.util.*;

//1//
public class Queue_prog {
  public static void main(String[] args) {
      PriorityQueue<Integer> mq =  new PriorityQueue<Integer>();
      Scanner input = new Scanner(System.in);
      System.out.println("Enter queue length: ");
      int size = input.nextInt();

      int array[] = new int[size];
      System.out.println("Insert queue elements:");

      for (int i = 0; i < size; i++) {
          array[i] = input.nextInt();
      }

      System.out.print ("Inserted queue elements:");
      for (int i = 0; i < size; i++) {
          mq.add(array[i]);
      }

      ///2//
      for (int item :array) {
          if (mq.size() < 10 || mq.peek() < item) {
              if (mq.size() == 10)
                  mq.remove();
              mq.add(item);
          }
      }
      System.out.println(mq);
  }

}
