import sun.text.resources.cldr.pa.FormatData_pa_Arab;

/**
 *  class Interface
 * <p>
 *      测试接口及继承、默认方法、实现
 * </p>
 * @author XuAn
 * @date 2019/7/19
 */
public class Interface {

    public static void main(String[] args) {
        carA car1 = new carA();
        car1.start();
        car1.stop();
        System.out.println("\n");
        Farrari LaFararri = new Farrari();
        LaFararri.start();
        LaFararri.start("LaFararri");
        LaFararri.stop();
    }
}

interface Engine {
    /**
     * start(); // 车辆启动
     */
    void start();

    /**
     * stop(); // 车辆停止
     */
    default void stop() {
        System.out.println("The car now stopped!");
    }
}
interface RaceEngine extends Engine {
    /**
     * 覆盖超类start()方法，带参数String
     * 覆盖不需要加@Override
     * @param carName 车的名字
     */
    default void start(String carName) {
        System.out.println("Wow! Fantastic " + carName
                + " racer! Let's go!");
    }
}
class carA implements Engine {
    /**使用@override确保覆盖方法正确*/
    @Override
    public void start() {
        System.out.println("carA has started!");
    }
}

class Farrari extends carA implements RaceEngine {
    /**
     * 继承carA并再次覆盖默认的start方法
     */
    @Override
    public void start(){
        System.out.println("Thank you for choosing Fararri!");
    }
}
