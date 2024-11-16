class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String s : ingredients.get(i)) {
                adj.computeIfAbsent(s, k -> new ArrayList<>()).add(recipes[i]);
                inDegree.put(recipes[i], inDegree.getOrDefault(recipes[i], 0) + 1);
            }
        }
        Deque<String> q = new ArrayDeque<>();
        for (String s : supplies) {
            q.addLast(s);
        }
        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            String current = q.pollFirst();
            if (!adj.containsKey(current)) {
                continue;
            }
            for (String next : adj.get(current)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    result.add(next);
                    q.addLast(next);
                }
            }
        }
        return result;
    }
}
