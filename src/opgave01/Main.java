package opgave01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>(List.of(17.0, 34.0, -23.0, 0.0, 202.0, 1.0));
        double sum = sum(numbers);
        System.out.println("sum = " + sum);
    }

    private static double sum(ArrayList<? extends Number> numbers) {
        return sum(numbers, 0, numbers.size() - 1);
    }

    private static double sum(ArrayList<?extends Number> numbers, int left, int right) {
        if (left > right) return 0;
        if (left == right) return numbers.get(left).doubleValue();

        int mid = (left + right) / 2; //Kan også skrives sådan, så man får differencen: left + (right-left)

        double sumLeft = sum(numbers, left, mid);
        double sumRight = sum(numbers, mid + 1, right);

        return sumLeft + sumRight;
    }
}
