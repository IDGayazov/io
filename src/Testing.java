public class Testing {
    public static int count = 0;
    public static void increment(){
        count++;
    };
    public static void main(String[] args) {
        increment();
        System.out.println(count);
    }
}
