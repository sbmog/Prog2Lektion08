package opgave03;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of("Janus", "Markus", "Peter", "Line", "Mads", "Søren", "Mathias", "Trine", "Anders"));
        int number = countStringsOfLength(names, 5);
        System.out.println("number = " + number);
        System.out.println();
        printElementsOfLength(names, 5);
        System.out.println();
        System.out.println("Navne med længde = 5 : " + elementsOfLength(names, 5));
    }


    /**
     * @param strings ArrayList of elements
     * @param length  the length to test for
     * @return the number of elements in strings with the specified length
     */
    public static int countStringsOfLength(ArrayList<String> strings, int length) {
        return countStringsOfLength(strings, length, 0, strings.size() - 1);
    }

    private static int countStringsOfLength(ArrayList<String> strings, int length, int left, int right) {
        if (left > right) return 0;
        if (left == right) {
            if (strings.get(left).length() == length) return 1;
            else return 0;
        }

        int mid = (left + right) / 2;

        int countLeft = countStringsOfLength(strings, length, left, mid);
        int countRight = countStringsOfLength(strings, length, mid + 1, right);

        return countLeft + countRight;
    }


    /**
     * Writes the elements of strings to the console with the specified lenght
     *
     * @param strings ArrayList of elements
     * @param length  the length to test for
     */
    public static void printElementsOfLength(ArrayList<String> strings, int length) {
        printElementsOfLength(strings, length, 0, strings.size() - 1);
    }

    private static void printElementsOfLength(ArrayList<String> strings, int length, int left, int right) {
        if (left > right) return;
        if (left == right) {
            if (strings.get(left).length() == length) {
                System.out.println(strings.get(left));
            }
            return;
        }

        int mid = (left + right) / 2;
        printElementsOfLength(strings, length, left, mid);
        printElementsOfLength(strings, length, mid + 1, right);
    }

    /**
     * @param strings ArrayList of elements
     * @param length  the length to test for
     * @return a new ArrayList with all elements from strings with the specified lenght
     */
    public static ArrayList<String> elementsOfLength(ArrayList<String> strings, int length) {
        return elementsOfLength(strings, length, 0, strings.size() - 1);
    }

    private static ArrayList<String> elementsOfLength(ArrayList<String> strings, int length, int left, int right) {
        if (left > right) return new ArrayList<>();
        if (left==right){
            ArrayList<String> result = new ArrayList<>();
            if (strings.get(left).length()==length){
                result.add(strings.get(left));
            }
            return result;
        }

        int mid =(left+right)/2;

        ArrayList<String> leftList = elementsOfLength(strings, length, left, mid);
        ArrayList<String> rightList = elementsOfLength(strings, length, mid+1, right);

        leftList.addAll(rightList);
        return leftList;
    }
}
