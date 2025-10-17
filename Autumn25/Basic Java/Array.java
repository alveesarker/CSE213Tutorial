public class Array {
    public static void main(String[] args) {

        String s = "Hello";
        int x = 10;
        float y = 10.5f;
        double i = 10.48;
        char c = 'A';

        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        int[] myNum = { 1, 2, 4, 5, 6 };

        System.out.println(cars[1]);
        myNum[1] = 0;
        System.out.println(myNum[1]);

        System.out.println(myNum.length);

        String[] cars1 = new String[4];

        cars1[0] = "Volvo";
        cars1[1] = "BMW";
        cars1[2] = "Ford";
        // cars[3] = "Mazda";

        System.out.println(cars1[4]);

        String[] cars_2 = { "Volvo", "BMW", "Ford", "Mazda" };

        // for (int i = 0; i < cars.length; i++) {
        // System.out.println(cars[i]);
        // }

        for (int j = 0 ; j < cars_2.length; j++){
        System.out.println(cars_2[j]);
        }

        int[] numbers = { 1, 5, 10, 25 };
        int sum = 0;

        // Loop through the array and add each element to sum
        for (int k = 0; k < numbers.length; k++) {
            sum = sum + numbers[k];
        }

        System.out.println("The sum is: " + sum);
    }
}
