import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShowNumbers {
    // Display grid numbers as integers
    public static void showNumbers() {

        // Since text-file is 20x20, array will need to be multi-dimensional
        int[][] myNumbers = new int[20][20];

        try {
            // Source path for text-file
            File caseText = new File("src/textfile/grid.txt");
            Scanner myReader = new Scanner(caseText);

            // Number for row, start at 0
            int row = 0;

            // Prevent from going over furthest row - O(n)
            while (myReader.hasNextLine() && row < 20) {
                String line = myReader.nextLine().trim();
                String[] parts = line.split("\\s+"); // Remove spacing

                // Add numbers to the array - O(n2)
                for (int column = 0; column < parts.length; column++) {
                    myNumbers[row][column] = Integer.parseInt(parts[column]);
                }

                // increase row
                row++;
            }
            myReader.close();

            // Display array in terminal - O(n2)
            for (int r = 0; r < 20; r++) {
                for (int c = 0; c < 20; c++) {
                    System.out.print(myNumbers[r][c] + " ");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

}
