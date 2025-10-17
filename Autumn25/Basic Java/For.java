public class For {
    public static void main(String[] args) {

        // statement1 - first(one time)
        // statement2 - before(every time) the execution of codeblock
        // statement3 - after(every time) the executino of codeblock
        // for(statement1 ; statement2 ; statement3){
        // // clodeblock to be executed
        // }

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int[] numbers = { 1, 5, 10, 25 };
        int sum = 0;

        // Loop through the array and add each element to sum
        for (int k = 0; k < numbers.length; k++) {
            sum = sum + numbers[k];
        }

        // 1st s -> 2nd s(if true) -> codeblock -> 3rd s -> 2nd s(if true) -> codeblock -> 3rd s -> 2nd s(if false) -> out of the loop
    }
}
