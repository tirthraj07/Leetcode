import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    private static HashMap<Integer, List<Character>> map;
    static {
        map = new HashMap<>() {
            {
                put(2, new ArrayList<Character>(List.of('a', 'b', 'c')));
                put(3, new ArrayList<Character>(List.of('d', 'e', 'f')));
                put(4, new ArrayList<Character>(List.of('g', 'h', 'i')));
                put(5, new ArrayList<Character>(List.of('j', 'k', 'l')));
                put(6, new ArrayList<Character>(List.of('m', 'n', 'o')));
                put(7, new ArrayList<Character>(List.of('p', 'q', 'r', 's')));
                put(8, new ArrayList<Character>(List.of('t', 'u', 'v')));
                put(9, new ArrayList<Character>(List.of('w', 'x', 'y', 'z')));
            }
        };
    }

    private ArrayList<Integer> nums;

    private List<String> backtrack(int index) {
        if (index == nums.size()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> perms = backtrack(index + 1);
        List<String> res = new ArrayList<>();

        for (String perm : perms) {
            for (Character c : map.get(nums.get(index))) {
                res.add(new String(c + perm));
            }
        }

        return res;
    }

    public List<String> letterCombinations(String digits) {
        List<String> sol = new ArrayList<>();
        this.nums = new ArrayList<>();
        if (digits.isEmpty())
            return sol;

        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            nums.add(digit);
        }

        sol = backtrack(0);

        return sol;
    }
}