public class TwoAddOperator {
    public static void main(String[] args) {
        int i = 10;
        int n = i++ % 5; // backward operator
        System.out.println("Expected Output:n = 0");
        System.out.println("Actual Output n = " + n);

        i = 10;
        n = ++i % 5; // forward operator
        System.out.println("Expected output:n = 1");
        System.out.println("Actual Output n = " + n);
        String a = "Hello, anger!";

    }
}
