/**package java_advanced1;

import java.util.*;
public class Lists {
    //==================================-------Arrray_List------------==============================================
    public static void main(String[] args) {
        //1
        List<String> list_colours = new ArrayList<>();
        List<String> list_colours2 = new ArrayList<>();
        list_colours.add("Orange");
        list_colours.add("Blue");
        list_colours.add("Black");
        list_colours.add("Purple");
        list_colours.add("Green");

        //2
        for(String str:list_colours){
            System.out.println(str);
        }
        //3
        list_colours.add(0,"Yellow");
        //4
        String str2 = list_colours.get(0);
        //5
        list_colours.set(0,"White");
        //6
        list_colours.remove(3);
        //7
        if(list_colours.contains("Orange")){
            System.out.println("found element");
        }else {
            System.out.println("No such element");
        }
        //8
        Collections.sort(list_colours);
        //9
        Collections.copy(list_colours,list_colours2); // without collections
        //10
        Collections.shuffle(list_colours2);
        //11
        Collections.reverse(list_colours);
        //12
        List<String> subcolours = list_colours.subList(0,1);
        System.out.println("sub list : " + subcolours);
        //13
        List<String> comparel = new ArrayList<>();
        for(String st :list_colours){
            comparel.add(list_colours2.contains(st)  ? "T":"F");
        }
        System.out.println(comparel);

        //14
        Collections.swap(list_colours,0,3);
        //15
        List<String> addedlist = new ArrayList<>();
        addedlist.addAll(list_colours);
        addedlist.addAll(subcolours);
        //16
        ArrayList<String> copy = new ArrayList<>(list_colours);
        //17
        copy.removeAll(copy);
        //18
        System.out.println("copy is empty " + copy.isEmpty());
        //19
        ((ArrayList<String>) list_colours2).trimToSize();
        //20
        ((ArrayList<String>) list_colours).ensureCapacity(8);
        list_colours.add("Red");
        list_colours.add("Cyan");
        list_colours.add("Gray");
        System.out.println("extra: " + list_colours);
        //21
        list_colours.set(1,"Light Blue");
        //22
        for (int i = 0 ; i < list_colours.size(); i ++){
            System.out.println(list_colours.get(i));
        }
        //==================================-------Linked_List------------==============================================
        //1
        LinkedList<String> l_list =new LinkedList<>();

        l_list.add("New York");
        l_list.add("Almaty");
        l_list.add("Saint Pitersbruh");
        l_list.add("Alabama");
        l_list.add("Moscow");
        l_list.add("Nursultan");
        l_list.add("Toronto");

        //2
        for (String elem : l_list) {
            System.out.println(elem);
        }
        //3
        Iterator it = l_list.listIterator(1);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //4
        Iterator it2 = l_list.descendingIterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }

        //5
        l_list.add(1,"Kyzylorda");
        //6
        l_list.addFirst("Aktau");
        l_list.addLast("Almaty2");
        //7
        l_list.offerFirst("Toronto");
        //8
        l_list.offerLast("Toronto2");
        //9
        LinkedList<String>  l_list2 = new  LinkedList<>();
        LinkedList<String> l_list3 = new LinkedList<>();
        l_list2.add("Moscow2");
        l_list2.add("Tokyo");
        l_list.addAll(2,l_list2);
        l_list3.addAll(l_list2);

        //10
        System.out.println("First " + l_list.getFirst());
        System.out.println("Last " + l_list.getLast());

        //11
        for (int i =0; i < l_list.size(); i++){
            System.out.println("index: " + i + ": " + l_list.get(i));
        }
        //12
        l_list.remove(1);
        //13
        l_list.removeFirst();
        l_list.removeLast();
        //14
        l_list2.clear();
        //15
        swap(l_list,0,2);
        //16
        Collections.shuffle(l_list);
        //17
        LinkedList<String>  l = new LinkedList<>();
        l.addAll(l_list); l.addAll(l_list2);
        //18
        LinkedList<String> l2 = new LinkedList<>();
        l2 = (LinkedList)l.clone();
        //19
        l2.pop();
        //20
        l2.peekFirst();
        //21
        l2.peekLast();
        //22
        if(l2.contains("Toronto2")){
            System.out.println("T");
        }else {
            System.out.println("F");
        }
        //23
        List<String> list_but_arr = new ArrayList<>(l_list2);
        //24
        LinkedList<String> l3 = new LinkedList<String>();
        for(String s : l_list){
            l3.add(l_list3.contains(s) ? "T":"F");
            System.out.println(l3);
        }
        //25
        l_list3.isEmpty();
        //26
        l_list3.set(0,"London");

    }
    public  static  <String> void  swap (List<String> list, int i ,int j){
        String string = list.get(i);
        list.set(i,list.get(j));
        list.set(j,string);
    }


}


/**
 Java Collection: LinkedList Exercises

 1. Write a Java program to append the specified element to the end of a linked list.


 2. Write a Java program to iterate through all elements in a linked list.


 3. Write a Java program to iterate through all elements in a linked list starting at the specified position.


 4. Write a Java program to iterate a linked list in reverse order.


 5. Write a Java program to insert the specified element at the specified position in the linked list.


 6. Write a Java program to insert elements into the linked list at the first and last position.


 7. Write a Java program to insert the specified element at the front of a linked list.


 8. Write a Java program to insert the specified element at the end of a linked list.


 9. Write a Java program to insert some elements at the specified position into a linked list.


 10. Write a Java program to get the first and last occurrence of the specified elements in a linked list.


 11. Write a Java program to display the elements and their positions in a linked list.


 12. Write a Java program to remove a specified element from a linked list.


 13. Write a Java program to remove first and last element from a linked list.


 14. Write a Java program to remove all the elements from a linked list.


 15. Write a Java program of swap two elements in an linked list.


 16. Write a Java program to shuffle the elements in a linked list.


 17. Write a Java program to join two linked lists.


 18. Write a Java program to clone an linked list to another linked list.


 19. Write a Java program to remove and return the first element of a linked list.


 20. Write a Java program to retrieve but does not remove, the first element of a linked list.


 21. Write a Java program to retrieve but does not remove, the last element of a linked list.


 22. Write a Java program to check if a particular element exists in a linked list.


 23. Write a Java program to convert a linked list to array list.


 24. Write a Java program to compare two linked lists.


 25. Write a Java program to test an linked list is empty or not.


 26. Write a Java program to replace an element in a linked list.
 **/