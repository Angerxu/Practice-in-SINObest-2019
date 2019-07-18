import java.util.Arrays;
import java.util.List;

public class Lambda {
    /**interface with only one method*/
    interface LambdaTest {
        public void output1(int number);
    }

    public static void main(String[] args) {
        // first lambda to print the integer
        LambdaTest l1 = (i) -> System.out.println(i);
        // second lambda to print a string + a number
        LambdaTest l2 = (i) -> System.out.println("This is a Lambda test!Your number: "
                        + i + "\n");
        l1.output1(5);
        l2.output1(0);
        //for-each iterator in List
        List testList = Arrays.asList("Lambda", "Interface", "Stream API");
        testList.forEach(n -> System.out.println(n));
    }

}
