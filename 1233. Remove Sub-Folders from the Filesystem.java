class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie database = new Trie("");
        for (String f : folder) {
            String[] split = f.split("/");
            database.add(split);
        }
        List<String> result = new ArrayList<>();
        populate(result, database, new StringBuilder());
        return result;
    }
    private void populate(List<String> result, Trie current, StringBuilder sb) {
        int size = sb.length();
        if (current.current.length() != 0) {
            sb.append("/");
            sb.append(current.current);
        }
        if (current.isEnd) {
            result.add(sb.toString());
            sb.setLength(size);
            return;
        }
        for (Trie t : current.children.values()) {
            populate(result, t, sb);
        }
        sb.setLength(size);
    }
}

class Trie {
    Map<String, Trie> children;
    String current;
    boolean isEnd;

    Trie(String current) {
        children = new HashMap<>();
        isEnd = false;
        this.current = current;
    }

    void add(String[] folder) {
        Trie current = this;
        for (String  s : folder) {
            if (!current.children.containsKey(s)) {
                current.children.put(s, new Trie(s));
            }
            current = current.children.get(s);
        }
        current.isEnd = true;
    }
}