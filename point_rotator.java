public class point_rotator {
    public static void main(String[] args) {

    }
    public static double radToDeg(double theta) {
        theta /= Math.PI;
        theta *= 180;
        return theta;
    }
    public static double degToRad(double theta) {
        theta /= 180;
        theta *= Math.PI;
        return theta;
    }
    public static double[] rotatePoint(double x, double y, double theta) {
        double newX = x*Math.cos(theta) + y*Math.sin(theta);
        double newY = x*Math.sin(theta) + y*Math.cos(theta);
        return new double[]{newX, newY};
    }
}