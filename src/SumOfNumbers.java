import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SumOfNumbers {

    public static void findHighestNumbers() {
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

                // increase row-count
                row++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        // FINDING LARGEST SUM IN ARRAY - WORKS
        // Nested loop for finding the largest number
        //for-loop to iterate through entire array
        // compare each number in array to highestNumber-variable
        // add number to highestNumber
        // print the largest number
        for (int row = 0; row < 20; row++){
            for (int col = 0; col < 20; col++){
                if (myNumbers[row][col] > highestNumber) {
                    highestNumber = myNumbers[row][col];
                    rowIndexOfArray = new int[]{row+1};
                    columnIndexOfArray = new int[]{col+1};
                }
            }
        }
        System.out.println("Highest number in the array is " + highestNumber + ", located at row: " + Arrays.toString(rowIndexOfArray) + ", column: " + Arrays.toString(columnIndexOfArray));


        // BRUTE FORCE METHOD FOR FINDING THE FOUR LARGEST NUMBERS
        // Search through entire array for largest product of four numbers
        // Nested loop to go through entire array
            // ignore the highest number from array, to prevent copy, when adding to sum
                // add second, third, fourth-highest number to total sum
                    // print total sum in terminal
        int firstNumber = highestNumber;
        int secondNumber = highestNumber-1;
        int thirdNumber = highestNumber-2;
        int fourthNumber = highestNumber-3;

        for (int row = 0; row < 20; row++){
            for (int col = 0; col < 20; col++){
                if (myNumbers[row][col] < secondNumber) {
                    secondNumber = myNumbers[row][col];
                    System.out.println(secondNumber);
                }
            }
        }

    }

    public static void main(String[] args) {
        findHighestNumbers();
    }
}


