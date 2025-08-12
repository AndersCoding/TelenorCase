import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FindNumbers {

    public static void findNumbers() {

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

            // Display array in terminal - O(n2) - r = row, c = column
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

    public static int findHighestNumber() {
        int[][] myNumbers = new int[20][20];

        // variable to contain the highest number in array
        int highestNumber = myNumbers[0][0];

        // Containers for the columns and rows of the main array
        int[] rowIndexOfArray = myNumbers[0];
        int[] columnIndexOfArray = myNumbers[0];

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
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        // Nested loop for finding the largest number - WORKS
            //for-loop to iterate through entire array
                // compare each number in array to highestNumber-variable
                    // add number to highestNumber
                        // print the largest number
        for (int r = 0; r < 20; r++){
            for (int c = 0; c < 20; c++){
                if (myNumbers[r][c] > highestNumber) {
                    highestNumber = myNumbers[r][c];
                    rowIndexOfArray = new int[]{r+1};
                    columnIndexOfArray = new int[]{c+1};
                }
            }
        }
        System.out.println("Highest number in the array is " + highestNumber + ", located at row: " + Arrays.toString(rowIndexOfArray) + ", column: " + Arrays.toString(columnIndexOfArray));



        return 0;
    }

    public static void main(String[] args) {
        findHighestNumber();
    }
}
