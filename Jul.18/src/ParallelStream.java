import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  ParallelStream class
 *  <p>
 *      Stream Class实战及并发Stream
 *  </p>
 * @author XuAn
 *
 * @date 2019/7/18
 */
public class ParallelStream {
    private static int size = 1000000;
    public static void testList() {
        List<Integer> list = new ArrayList<>(size);
        for (Integer i = 0; i < size; i++) {
            list.add(new Integer(i));
        }

        List<Integer> temp1 = new ArrayList<>(size);
        /*System.currentTimeMillis()方法记录从1970.1.1到现在的毫秒数。*/
        Long start = System.currentTimeMillis();
        for (Integer i : list) {
            temp1.add(i);
        }
        System.out.println(+System.currentTimeMillis() - start);

        // 同步
        Long start1 = System.currentTimeMillis();
        list.stream().collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start1);

        // 并发
        Long start2 = System.currentTimeMillis();
        list.parallelStream().collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start2);
    }
    public static void testSet() {
        List<Integer> list = new ArrayList<>(size);
        for (Integer i = 0; i < size; i++) {
            list.add(new Integer(i));
        }

        Set<Integer> temp1 = new HashSet<>(size);
        Long start = System.currentTimeMillis();
        for(Integer i : list) {
            temp1.add(i);
        }
        System.out.println(+System.currentTimeMillis() - start);

        // 同步
        Long start1 = System.currentTimeMillis();
        list.stream().collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start1);

        // 并发
        Long start2 = System.currentTimeMillis();
        list.parallelStream().collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start2);
    }
    public static void main(String[] args) {
        System.out.println("---List---");
        testList();
        System.out.println("---Set---");
        testSet();
    }
}
