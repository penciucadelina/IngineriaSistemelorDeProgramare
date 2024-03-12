package isp.lab3.exercise2;

public class Rectangle {
    //atribute private
    private int length;
    private int width;
    private String color;

    //constructor implicit
    public Rectangle() {
        this.length = 2;
        this.width = 1;
        this.color = "red";
    }

    //constructori expliciti
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.color = "red";
    }

    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    // Metode publice
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return 2 * length + 2 * width;
    }

    public int getArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5, 3, "blue");
        Rectangle rectangle2 = new Rectangle();


        System.out.println("Length: " + rectangle1.getLength());
        System.out.println("Width: " + rectangle1.getWidth());
        System.out.println("Color: " + rectangle1.getColor());
        System.out.println("Perimeter: " + rectangle1.getPerimeter());
        System.out.println("Area: " + rectangle1.getArea());

        System.out.println("Length: " + rectangle2.getLength());
        System.out.println("Width: " + rectangle2.getWidth());
        System.out.println("Color: " + rectangle2.getColor());
        System.out.println("Perimeter: " + rectangle2.getPerimeter());
        System.out.println("Area: " + rectangle2.getArea());
    }


}

