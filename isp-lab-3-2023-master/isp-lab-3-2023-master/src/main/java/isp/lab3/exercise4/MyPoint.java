package isp.lab3.exercise4;

public class MyPoint {
    //atribute private
    private int x;
    private int y;
    private int z;

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public MyPoint() {
        this(0, 0, 0);
    }

    // Getter si setter pt x
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // Getter si setter pt y
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Getter si setter pt z
    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }


    public double distance(int x, int y, int z) {
        int xx = this.x - x;
        int yy = this.y - y;
        int zz = this.z - z;
        return Math.sqrt(xx * xx + yy * yy + zz * zz);
    }

    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY(), another.getZ());
    }

    public static void main(String[] args) {

        MyPoint point1 = new MyPoint(3, 2, 2);
        MyPoint point2 = new MyPoint(1, 5, 6);


        double distance = point1.distance(point2);
        System.out.println("Distanta dintre punctul 1 " + point1 + " si punctul 2 " + point2 + " este: " + distance);
    }
}