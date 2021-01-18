package java_advanced1.Movable;

import java_advanced1.ArrayList;

public class ListMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0; i<5; i++){
            list.add(i+1);

        }

        list.set(0,0);
        list.remove(0);
        list.get(1);
        System.out.println();
    }
}
