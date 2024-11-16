class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String folder : folders) {
            if (".".equals(folder)) continue;
            if ("..".equals(folder)) {
                if (!stack.isEmpty()) stack.pollLast();
                continue;
            }
            if ("".equals(folder)) continue;
            stack.addLast(folder);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
