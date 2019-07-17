public class ParametersArguments {


    public static void main(String[] args) {
        Point p = new Point();
        p.movePoint(p, 2, 3);
        System.out.println("x:" + p.x + ", y:" + p.y);
    }

}
class Point {
    int x;
    int y;
    public Point() {
        x = 0;
        y = 0;
    };
    public Point(int newX, int newY) {
        x = newX;
        y = newY;
    };
    public void setX(int newValue) {
        x = newValue;
    };

    public void setY(int newValue) {
        y = newValue;
    };
    public void movePoint(Point point, int newX, int newY) {
        point.setX(newX);
        point.setY(newY);
        point=new Point();//无实参的构造函数，函数结束后不对实参产生影响
    }
}