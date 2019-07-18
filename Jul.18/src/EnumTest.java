/**
 *  EnumTest class
 * <p>
 *     元组功能及静态值方法与for-each的结合运用
 * </p>
 * @author XuAn
 *
 * @date 2019/7/18
 *
 */
public class EnumTest {
    public enum Planet {
        /**在enum中首先定义常量/
        /**Planet EARTH*/
        MERCURY (3.303e+23, 2.4397e6),
        VENUS (4.869E+24, 6.0518e6),
        MARS (6.421E+23, 3.3972E6),
        EARTH (5.976e+24, 6.37814e6);
        /**再声明字段和构造器*/
        private double mass, radius;
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }
        private double getMass() {
            return mass;
        }
        private double getRadius() {
            return radius;
        }

        /**universal gravitational constant (m3 kg - 1 s - 2)*/
        public static final double G = 6.67300E-11;

        double surfaceGravity() {
            return G * mass / (radius * radius);
        }
        double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity();
        }

    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()){
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
        }
    }
}

