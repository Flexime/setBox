package java_advanced1;



import java.util.*;

public class hash {

    public static void main(String[] args) {


        Map<String,String> hmCountry  = new HashMap<>();
        Map<String,String> hmCountry2  = new HashMap<>();
        Map<String,Integer> treemap = new TreeMap<>();
        Map<String,Integer> linkedHashMap = new LinkedHashMap<>();
        func(linkedHashMap);

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        //1
        hmCountry.put("ES","Spain");
        hmCountry.put( "DE","Germany");
        hmCountry.put("Fr","France");
        hmCountry.put("CN","Chine");
        hmCountry.put("US","United States");
        hmCountry.put("RU","Rusia");

        hmCountry2.put("US","United States");
        hmCountry2.put("RU","Rusia");
        hmCountry2.put("KZ","Kazakhstan");
        hmCountry2.put("GB","Great Britain");


        //2. Count the number of key-value (size) mappings in a map.
        System.out.println("size: " + hmCountry.size());

        //3 Copy all of the mappings from the specified map to another map.
        hmCountry.putAll(hmCountry2);
        //4 Remove all of the mappings from a map.
        hmCountry2.clear();
        //5 Check whether a map contains key-value mappings (empty) or not.
        boolean isempty = hmCountry2.isEmpty();
        System.out.println("isempty: " + isempty);
        //6 Test if a map contains a mapping for the specified key.
        if(hmCountry.containsKey("RU")){
            System.out.println("contains: " + hmCountry.get("RU"));
        }else {
            System.out.println("dont contain key");
        }
        //7 Test if a map contains a mapping for the specified value.
        if (hmCountry.containsValue("France")){
            System.out.println("contains: " + hmCountry.get("France"));
        }else {
            System.out.println("dont contain value");
        }
        //8 Create a set view of the mappings contained in a map.
        Set set = hmCountry.entrySet();
        System.out.println("set vals: " + set);
        //9 Get the value of a specified key in a map.
        String str = (String)hmCountry.get(2);
        System.out.println("val for 2 : " + str);
        //10 Get a set view of the keys contained in this map.
        Set keyset = hmCountry.keySet();
        System.out.println("keys: " + keyset);
        //11Get a collection view of the values contained in this map.
        System.out.println("Collection view: " + hmCountry.values());
        //12 Convert given HashMap into TreeMap.
        TreeMap<String,String> treeMap = new TreeMap<String,String>(hmCountry);
        System.out.println("tree: " + treeMap);
        //13. Write a Java program to get the first (lowest) key and the last (highest) key currently in a map.
        System.out.println("low: " + treeMap.firstKey());
        System.out.println("high: " + treeMap.lastKey());
        //14 Write a Java program to get the portion of a map whose keys range from a given key to another key.
        SortedMap < String, String > sub_map = new TreeMap < String, String> ();
        sub_map = treeMap.subMap("CN","RU");
        System.out.println("sub_map: " + sub_map);
        //15. Write a Java program to get a reverse order view of the keys contained in a given map.
        System.out.println("uno reverse order: " + treeMap.descendingKeySet());
    }




    public static void func(Map<String,Integer> map) {
        int value[] = {1,2,3,4,6};
        String key[] = {"one","two","three","four","Five"};

        for (int i =0; i<key.length;i++){
            map.put(key[i],value[i]);

            for (Map.Entry<String,Integer>entry: map.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
