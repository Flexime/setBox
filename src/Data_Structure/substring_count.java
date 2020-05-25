package Data_Structure;

public class substring_count {
    public static void main(String[] args) {
        String s = "Hello have a nice day , good day for you!";
        int count = (s.split("day ",-1).length)-1; // regex is desired elemen
        // count in split till end
        System.out.println("occured: " + count);

         String snew =  s.replace("day","");
        System.out.println(snew);
    }
}
