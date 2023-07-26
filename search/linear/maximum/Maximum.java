package search.linear.maximum;

import java.util.ArrayList;

public class Maximum {

    public static Integer linearSearch(int[] searchList) {
        Integer maximumScoreIndex = null;
        for (int idx = 0; idx < searchList.length; idx++) {
            if (maximumScoreIndex == null || searchList[idx] > searchList[maximumScoreIndex]) {
                maximumScoreIndex = idx;
            }
        }
        return maximumScoreIndex;
    }

    public static void main(String[] args) {
        int[] testScores = {88, 93, 75, 100, 80, 67, 71, 92, 90, 83};

        Integer highestScoreIndex = linearSearch(testScores);

        if (highestScoreIndex != null) {
            int highestScore = testScores[highestScoreIndex];
            System.out.println("The highest score in the list is: " + highestScore);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
