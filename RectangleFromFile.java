import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RectangleFromFile {
    public static void main(String[] args) {
        File file = new File("rectangles.txt");

        

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Processing line: \"" + line + "\""); // Debug print to check the input line

                try {
                    String[] parts = line.split(" ");

                    // Check if the line has exactly two parts
                    if (parts.length < 2) {
                        System.out.println("Skipping invalid line: \"" + line + "\" (missing values)");
                        continue;  // Skip this iteration and move to the next line
                    }

                    // Try to parse width and height, handling invalid number format
                    int width = Integer.parseInt(parts[0]);
                    int height = Integer.parseInt(parts[1]);

                    // Create a rectangle and print its area
                    Rectangle r = new Rectangle(0, 0, width, height);
                    System.out.println("Rectangle: " + r + ", Area: " + (width * height));

                } catch (NumberFormatException e) {
                    // Handle non-numeric input
                    System.out.println("Skipping invalid line: \"" + line + "\" (invalid numbers)");
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Handle lines with missing width/height values
                    System.out.println("Skipping invalid line: \"" + line + "\" (missing values)");
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: rectangles.txt");
        }
    }
}