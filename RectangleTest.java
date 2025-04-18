import java.awt.Rectangle;
import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle box1 = new Rectangle(10, 10, 40, 30);
        System.out.println("box1: " + box1);
        Rectangle box2 = new Rectangle(0, 0, 100, 50);
        System.out.println("Box2: " + box2);

        box1.setLocation(20, 20);

        box2.setSize(50, 30);

        System.out.println("After updates:");
        System.out.println("Box1: " + box1);
        System.out.println("Box2: " + box2);

        Rectangle box3 = box1.intersection(box2);

        int area = box3.width * box3.height;
        System.out.println("Box3 (Intersection): " + box3);
        System.out.println("Area of Box3: " + area);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter width: "); 
        int width = input.nextInt();
        System.out.print("Enter height: "); 
        int height = input.nextInt();
        int userArea = height * width;
        System.out.println("Your box area is: " + userArea);

        int expectedArea = width * height;

        if (area == expectedArea) {
            System.out.println("++++ Test passed: Area is correct.");
        } else {
            System.out.println("---- Test failed: Expected " + expectedArea + " but got " + area);
        }
    }

}