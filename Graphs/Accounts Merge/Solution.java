import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// There is a more optimum solution using Disjoint Union Sets. I haven't learnt that yet so this will do for now
// 38 ms Java Solution using DFS

class Solution {
    private void dfs(String email, LinkedList<String> emails, HashSet<String> visited,
            Map<String, ArrayList<String>> adjList) {
        if (visited.contains(email))
            return;

        emails.add(email);
        visited.add(email);
        for (String neighbour : adjList.get(email)) {
            dfs(neighbour, emails, visited, adjList);
        }

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, ArrayList<String>> adjList = new HashMap<>();
        for (List<String> lst : accounts) {
            for (int i = 1; i < lst.size(); i++) {
                if (!adjList.containsKey(lst.get(i))) {
                    adjList.put(lst.get(i), new ArrayList<>());
                }
                if (i > 1) {
                    // Create a undirected link between the two nodes
                    adjList.get(lst.get(i - 1)).add(lst.get(i));
                    adjList.get(lst.get(i)).add(lst.get(i - 1));
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();

        for (List<String> lst : accounts) {
            if (visited.contains(lst.get(1)))
                continue;
            String name = lst.get(0);
            LinkedList<String> emails = new LinkedList<>();
            dfs(lst.get(1), emails, visited, adjList);
            Collections.sort(emails);
            emails.addFirst(name);
            result.add(emails);
        }

        return result;
    }
}