/**
 * class Inherit
 * <p>
 *     类的继承、通过接口多重继承实现
 * </p>
 * @author XuAn
 * @date 2019/7/19
 */
public class Inherit {
    public static void main(String[] args) {
        /*static method of Wheel*/
        Wheel.printWheel();
        /*static method of Bicycle*/
        Bicycle.printWheel();
        /*static method of MountainBike，屏蔽Bicycle中的静态方法*/
        MountainBike.printWheel();

        Bicycle bike = new Bicycle(2, 3, 4);
        bike.printDescription();
        /*多态的自行车*/
        bike.printRing();

        MountainBike mountainBike = new MountainBike(5, 5,
                10, "Giant");
        mountainBike.printDescription();
        mountainBike.printRing();
        mountainBike.setSuspension("Panda");
        System.out.println("The suspension is : " + mountainBike.getSuspension()
                            + ".\n");

        RoadBike roadBike = new RoadBike(9, 5, 2, 7);
        roadBike.printDescription();
        roadBike.setTireWidth(666);
        System.out.println("The tire width is : " + roadBike.getTireWidth()
                + "mm.\n");
    }
}
/**
 * a wheel interface
 */
interface Wheel {
    /**
     * printWheel() 显示这是一个轮胎
     */
    static void printWheel() {
        System.out.println("This is just a wheel, without bike.");
    };
}
/**
 * a ring interface
 */
interface Ring {
    /**
     * printRing() 显示这是一个铃铛
     */
    void printRing();
}
/**
 * class Bicycle
 * 单车基类（超类）（父类）
 */
class Bicycle implements Wheel, Ring{
    private int startCadence;
    private int startSpeed;
    private int startGear;

    Bicycle(int startCadence, int startSpeed, int startGear) {
        this.startCadence = startCadence;
        this.startSpeed = startSpeed;
        this.startGear = startGear;
    }
    public int getStartCadence() {
        return this.startCadence;
    }
    public int getStartSpeed() {
        return this.startSpeed;
    }
    public int getStartGear() {
        return this.startGear;
    }

    /**
     * a print method in super class
     */
    public void printDescription() {
        System.out.println("\nBike is " + "in gear " + this.startGear
                + " with a cadence of " + this.startCadence +
                " and travelling at a speed of " + this.startSpeed + ".");
    }

    /**
     * static method in subclass from interface
     */
    public static void printWheel() {
        System.out.println("This is a wheel on the bike.");
    }

    /**
     * override method from interface
     */
    @Override
    public void printRing() {
        System.out.println("This is a ring on the bike.");
    }
}

class MountainBike extends Bicycle implements Wheel, Ring{
    private String suspension;

    MountainBike(
            int startCadence,
            int startSpeed,
            int startGear,
            String suspensionType) {
        /*
         * 使用super()调用超类的构造器，必须位于子类构造器第一行
         */
        super(startCadence,startSpeed,startGear);
        this.setSuspension(suspensionType);
    }
    public String getSuspension() {
        return this.suspension;
    }

    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;
    }
    /**
     * print method override in MountainBike
     * 覆盖
     */
    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("The " + "Mountain Bike has a "
                + getSuspension() + " suspension.\n");
    }

    /**
     * 屏蔽Bicycle中的printWheel()方法
     */
    public static void printWheel() {
        System.out.println("This is a wheel on a mountain bike.");
    }

    @Override
    public void printRing() {
        System.out.println("This is a ring on a mountain bike.");
    }
}

class RoadBike extends Bicycle{
    private int tireWidth;

    public RoadBike(int startCadence,
                    int startSpeed,
                    int startGear,
                    int newTireWidth) {
        /*
         * 使用super()调用超类的构造器，必须位于子类构造器第一行
         */
        super(startCadence,
                startSpeed,
                startGear);
        this.setTireWidth(newTireWidth);
    }

    public int getTireWidth() {
        return tireWidth;
    }

    public void setTireWidth(int newTieWidth) {
        this.tireWidth = newTieWidth;
    }
    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("The RoadBike" + "has "
                + getTireWidth() + "mm tires.\n");
    }
}

