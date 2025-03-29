import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    private static int[] MAX_CAPACITY = { 8, 5, 3 };
    private static ArrayList<List<int[]>> solutionList = new ArrayList<>();

    private static void dfs(ArrayList<int[]> currentPath, HashSet<String> visitedPermutations) {

        int[] lastCombination = currentPath.get(currentPath.size() - 1);
        if (lastCombination[0] == 4 && lastCombination[1] == 4 && lastCombination[2] == 0) {
            solutionList.add(List.copyOf(currentPath));
            return;
        }

        // Move water from i to j
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                int[] newPermutation = lastCombination.clone();
                newPermutation[j] = Math.min(MAX_CAPACITY[j], newPermutation[j] + newPermutation[i]);
                newPermutation[i] = lastCombination[i] - (newPermutation[j] - lastCombination[j]);
                String stateKey = Arrays.toString(newPermutation);
                if (!visitedPermutations.contains(stateKey)) {
                    visitedPermutations.add(stateKey);
                    currentPath.add(newPermutation);
                    dfs(currentPath, visitedPermutations);
                    visitedPermutations.remove(stateKey);
                    currentPath.removeLast();
                }
            }
        }

    }

    public static void main(String[] args) {
        HashSet<String> visitedPermutations = new HashSet<>();
        ArrayList<int[]> currentPath = new ArrayList<>();

        int[] buckets = new int[] { 8, 0, 0 };
        currentPath.add(buckets.clone());
        visitedPermutations.add(Arrays.toString(buckets));

        dfs(currentPath, visitedPermutations);

        if (solutionList.size() == 0) {
            System.out.println("No solution found");
            return;
        } else {
            System.out.println("No. of solutions: " + solutionList.size());
        }

        int minIndex = 0;
        for (int i = 0; i < solutionList.size(); i++) {
            if (solutionList.get(i).size() < solutionList.get(minIndex).size()) {
                minIndex = i;
            }
        }

        List<int[]> mostOptimalSolution = solutionList.get(minIndex);
        for (int[] bucket : mostOptimalSolution) {

            for (int i = 0; i < 3; i++) {
                System.out.print(bucket[i] + " ");
            }
            System.out.println();
        }

    }

}