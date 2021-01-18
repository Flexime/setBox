package java_advanced1;

public class bunnyEars2 {
    public int bunnyEars2(int bunnies) {
        return (bunnies == 0) ? 0 : 2 + bunnyEars2(bunnies - 1);
    }
}
