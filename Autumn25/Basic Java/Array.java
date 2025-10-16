public class Array {
    public static void main(String[] args) {

        // String s = "Hello";
        // int x = 10;
        // float y = 10.5f;
        // double i = 10.48;
        // char c = 'A';

        // String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        // int[] myNum = { 1, 2, 4, 5, 6 };

        // System.out.println(cars[1]);
        // myNum[1] = 0;
        // System.out.println(myNum[1]);

        // System.out.println(myNum.length);

        // String[] cars = new String[4];

        // cars[0] = "Volvo";
        // cars[1] = "BMW";
        // cars[2] = "Ford";
        // // cars[3] = "Mazda";

        // System.out.println(cars[4]);

        // String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };

        // // for (int i = 0; i < cars.length; i++) {
        // // System.out.println(cars[i]);
        // // }

        // for (int i = 0 ; i < cars.length; i++){
        // System.out.println(cars[i]);
        // }

        int[] numbers = { 1, 5, 10, 25 };
        int sum = 0;

        // Loop through the array and add each element to sum
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        System.out.println("The sum is: " + sum);
    }
}
