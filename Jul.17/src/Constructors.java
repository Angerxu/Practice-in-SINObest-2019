public class Constructors {
    private int dataX, dataY;
    private int height, weight;
    static int counter = 0;
    public Constructors() { // constructors with no parameters
        this(0, 0, 0, 0);
        System.out.println("call the no-parameters constructors.");
    }

    public Constructors(int height, int weight) { // constructors with two parameters
        this(0, 0, height, weight);
        System.out.println("call the two-parameters constructors.");
    }
    public Constructors(int dataX, int dataY,int height, int weight) {
        this.dataX = dataX;
        this.dataY = dataY;
        this.height = height;
        this.weight = weight;
        ++counter;
        System.out.println("call the full-parameters constructors.");
    }
    public void printClass() {
        System.out.println("dataX: " + this.dataX + ". dataY: " + this.dataY
        + ". height: " + this.height + ". weight: " + this.weight + ".\n"
        + "The counter is " + Constructors.counter + ".\n");
    }

    public static void main(String[] args) {
        Constructors classA = new Constructors();
        classA.printClass();
        Constructors classB = new Constructors(2, 3);
        classB.printClass();
        Constructors classC = new Constructors(2, 2, 3, 4);
        classC.printClass();
        Constructors classD = classC; // reference to the same classC
        classD.printClass();
        System.out.println("The number of class is created: " + Constructors.counter
                + ".");
    }
}
