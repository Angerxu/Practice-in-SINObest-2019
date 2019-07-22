/**
 * class Generics
 * <p>
 *     泛型运用
 * </p>
 * @author XuAn
 * @date 2019/7/22
 *
 */

public class Generics<T, V> {
    private T type;
    private V value;
    public Generics(T type, V value) {
        this.type = type;
        this.value = value;
    }
    public void setType(T t) {
        this.type = t;
    }
    public void setValue(V v) {
        this.value = v;
    }

    public T getType() {
        return this.type;
    }
    public V getValue() {
        return this.value;
    }

    //public int addOdd(Generics number) {
    //    static int addSum = 0;
    //}

    //public V addEven(Generics number) {
    //
    //}

    public static void main(String[] args) {
        Generics<String,Integer> number1 = new Generics<>("odd", 1);
        Generics<String,Integer> number2 = new Generics<>("Even", 2);
        Generics<String,Integer> number3 = new Generics<>("odd", 3);
        System.out.println("Type: " + number1.getType() + ".Value: "
                            + number1.getValue() + ".\n");
        number2.setType("Even");
        number2.setValue(666);
        System.out.println("Type: " + number2.getType() + ".Value: "
                            + number2.getValue() + ".\n");

        number3.setType("prime");
        number3.setValue(4);
        System.out.println("Type: " + number3.getType() + ".Value: "
                            + number3.getValue() + ".\n");


    }
}
