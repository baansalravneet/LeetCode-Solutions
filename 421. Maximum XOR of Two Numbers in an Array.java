class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode(' ', null, null);
        for (int i : nums) {
            insert(root, i);
        }
        int answer = 0;
        for (int i : nums) {
            int candidate = findCandidate(root, i);
            answer = Math.max(answer, candidate ^ i);
        }
        return answer;
    }
    private void insert(TrieNode root, int num) {
        String binary = String.format("%32s", Integer.toBinaryString(num)).replace(" ", "0");
        for (int i = 0; i < binary.length(); i++) {
            char nextChar = binary.charAt(i);
            if (nextChar == '0') {
                if (root.left == null) {
                    root.left = new TrieNode('0', null, null);
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = new TrieNode('1', null, null);
                }
                root = root.right;
            }
        }
    }
    private int findCandidate(TrieNode root, int num) {
        String binary = String.format("%32s", Integer.toBinaryString(num)).replace(" ", "0");
        int candidate = 0;
        for (int i = 0; i < binary.length(); i++) {
            char nextChar = binary.charAt(i);
            if (nextChar == '0') {
                if (root.right != null) {
                    root = root.right;
                    candidate = candidate*2 + 1;
                } else {
                    root = root.left;
                    candidate = candidate*2;
                }
            } else {
                if (root.left != null) {
                    root = root.left;
                    candidate = candidate*2;
                } else {
                    root = root.right;
                    candidate = candidate*2 + 1;
                }
            }
        }
        return candidate;
    }
}

class TrieNode {
    char value;
    TrieNode left;
    TrieNode right;
    TrieNode(char value, TrieNode left, TrieNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

