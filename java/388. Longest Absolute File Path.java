class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\\n");
        Deque<String> stack = new ArrayDeque<>();
        int stackSize = 0;
        int maxLength = 0;
        for (String line : lines) {
            String[] tabs = line.split("\\t");
            int level = tabs.length - 1;
            while (level < stack.size()) stackSize -= stack.pollLast().length();
            String name = tabs[tabs.length-1];
            stackSize += name.length();
            stack.addLast(name);
            if (name.indexOf(".") != -1) maxLength = Math.max(maxLength, stackSize + stack.size() - 1);
        }
        return maxLength;
    }
}
