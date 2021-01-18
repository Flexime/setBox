package java_advanced1;

import java.util.Arrays;

public  class  ArrayList<E> {
    private Object[] elements;
    private int size = 0;
    private final static int capacity = 10;
    private int current = 0;

    public ArrayList() {
        elements = new Object[capacity];
    }

    public void add(E data) {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }

        elements[size++] = data;
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Wrong index");
            return (E) elements[index];
        }
        public  void  remove(){
            elements =Arrays.copyOf(elements,--size);
        }

        public void  set (E data ,int index ){
        if(index< 0 || index>= size)
            throw  new IllegalArgumentException("Wrong index");
            elements[index] = data;
        }

        public  int length (){
        return this.size;
        }
      public  void  remove(int index){
            ArrayList.this.remove(--current);
      }

      public boolean contains (Object o) {
        boolean bool =false;
              if (o == null)
                 bool =  false;

          if (o == this)
              bool = true;


          return bool;
      }
      public  void  sort(Object[] elements ){


      }



    @Override
    public String toString(){
        String res  = "[";
        for(int i=0; i< elements.length ; i++){
            res = res + elements[i] + ",";
        }
        return  res.substring(0,res.length() -1 ) + "]";
}
@Override
    public  boolean equals(Object o){
        return false;
}

    public int Size (){
        return size;
    }
    public boolean isEmpty() {
    return Size() == 0;
    }
}