package opgave04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(List.of(15, 0, -23, 42, 101, Integer.MIN_VALUE, 202, 0, -3));
        System.out.println(mergeSort(integers));
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        ArrayList<Integer> leftList = new ArrayList<>(list.subList(0, mid));
        ArrayList<Integer> rightList = new ArrayList<>(list.subList(mid, list.size()));

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return merge(leftList, rightList);
    }


    private static ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> merged = new ArrayList<>();
        int indexLeft = 0, indexRight = 0;

        while (indexLeft < leftList.size() && indexRight < rightList.size()) {
            if (leftList.get(indexLeft) < rightList.get(indexRight)) {
                merged.add(leftList.get(indexLeft));
                indexLeft++;
            } else {
                merged.add(rightList.get(indexRight));
                indexRight++;
            }
        }
        while (indexLeft < leftList.size()) {
            merged.add(leftList.get(indexLeft));
            indexLeft++;
        }

        while (indexRight < rightList.size()) {
            merged.add(rightList.get(indexRight));
            indexRight++;
        }

        return merged;
    }
}


