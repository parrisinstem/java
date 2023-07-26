package sort.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
   
    public static List<Integer> mergeSort(List<Integer> items) {
        if (items.size() <= 1) {
            return items;
        }

        int middleIndex = items.size() / 2;
        List<Integer> leftSplit = new ArrayList<>(items.subList(0, middleIndex));
        List<Integer> rightSplit = new ArrayList<>(items.subList(middleIndex, items.size()));

        List<Integer> leftSorted = mergeSort(leftSplit);
        List<Integer> rightSorted = mergeSort(rightSplit);

        return merge(leftSorted, rightSorted);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0) < right.get(0)) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }

        result.addAll(left);
        result.addAll(right);

        return result;
    }

     public static void main(String[] args) {
        List<Integer> unorderedList1 = new ArrayList<>(Arrays.asList(356, 746, 264, 569, 949, 895, 125, 455));
        // List<Integer> unorderedList2 = new ArrayList<>(Arrays.asList(787, 677, 391, 318, 543, 717, 180, 113, 795, 19, 202, 534, 201, 370, 276, 975, 403, 624, 770, 595, 571, 268, 373));
        // List<Integer> unorderedList3 = new ArrayList<>(Arrays.asList(860, 380, 151, 585, 743, 542, 147, 820, 439, 865, 924, 387));

        List<Integer> orderedList1 = mergeSort(unorderedList1);
        // List<Integer> orderedList2 = mergeSort(unorderedList2);
        // List<Integer> orderedList3 = mergeSort(unorderedList3);

        System.out.println(orderedList1);
    }

}
