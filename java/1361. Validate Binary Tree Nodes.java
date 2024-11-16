// A binary tree must have a root, a node with no incoming edges or a node with no parents
// Every node other than the root must have exactly one parent.
// Every node myst be reachable from the root.
// There cannot be a cycle.

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // a node can either be a left child or a right child but not both.
        // a node has to be a child except one (root).
        Set<Integer> leftChildSet = new HashSet<>();
        Set<Integer> rightChildSet = new HashSet<>();
        for (int i : leftChild) {
            if (i != -1) leftChildSet.add(i);
        }
        for (int i : rightChild) {
            if (i != -1) rightChildSet.add(i);
        }
        
        if (!Collections.disjoint(leftChildSet, rightChildSet)) return false;
        System.out.println("disjoint didn't fail");
        
        int leftSize = leftChildSet.size();
        int rightSize = rightChildSet.size();
        if (leftSize + rightSize != n-1) return false;
        System.out.println("size condition didn't fail");

        // check if there is a cycle
        if (checkCycle(leftChild) || checkCycle(rightChild)) return false;
        return true;
    }
    private boolean checkCycle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1 && arr[arr[i]] != -1) {
                int slow = arr[i];
                int fast = arr[arr[i]];
                while (arr[fast] != -1 && arr[arr[fast]] != -1) {
                    if (slow == fast) return true;
                    slow = arr[slow];
                    fast = arr[arr[fast]];
                }
            }
        }
        return false;
    }
}
