public class MultiArray {
   static int[][] numbers = {{12,45,76,25,75,6,75,2}, {43,76,75,12,44,87,8,14}};

    public static void main(String[] args) {

        int sumOfNumbers = 0;

        int target = 14;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                sumOfNumbers += numbers[i][j];
                //System.out.print(numbers[i][j] + " ");
                if (numbers[i][j] == target) {
                    System.out.println("Target found at row " + i + " and column " + j);
                }
            }
        }
        System.out.println("");
        System.out.println(sumOfNumbers);

    }
}
