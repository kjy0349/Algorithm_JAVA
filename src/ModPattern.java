public class ModPattern {
    public static void main(String[] args) {
        long num = 1;
        for (int i = 0; i < 100; i++) {
            num *= 10;
            System.out.println(num + " " + num % 7);
        }
    }
}
