class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        Map<Integer, Integer> indexToValue = new HashMap<>();
        int peekIndex = findPeek(mountainArr, 0, n-1, indexToValue);
        int answer1 = findTargetLeft(0, peekIndex, mountainArr, target, indexToValue);
        int answer2 = findTargetRight(peekIndex+1, n-1, mountainArr, target, indexToValue);
        return answer1 != -1 ? answer1 : answer2;
    }

    private int findPeek(MountainArray ma, int left, int right, Map<Integer, Integer> map) {
        if (left >= right) return left;
        int mid = (left + right) / 2;
        if (mid == left || mid == right) return mid;
        int leftValue = getValueAt(map, ma, mid-1);
        int rightValue = getValueAt(map, ma, mid+1);
        int midValue = getValueAt(map, ma, mid);
        if (leftValue < midValue && rightValue < midValue) return mid;
        if (leftValue < midValue && rightValue > midValue) return findPeek(ma, mid+1, right, map);
        return findPeek(ma, left, mid-1, map);
    }

    private int getValueAt(Map<Integer, Integer> map, MountainArray ma, int index) {
        if (!map.containsKey(index)) {
            map.put(index, ma.get(index));
        }
        return map.get(index);
    }

    private int findTargetLeft(int left, int right, MountainArray ma, int target, Map<Integer,Integer> map) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        int valueAtMid = getValueAt(map, ma, mid);
        if (valueAtMid == target) return mid;
        if (valueAtMid > target) return findTargetLeft(left, mid-1, ma, target, map);
        return findTargetLeft(mid+1, right, ma, target, map);
    }

    private int findTargetRight(int left, int right, MountainArray ma, int target, Map<Integer,Integer> map) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        int valueAtMid = getValueAt(map, ma, mid);
        if (valueAtMid == target) return mid;
        if (valueAtMid < target) return findTargetRight(left, mid-1, ma, target, map);
        return findTargetRight(mid+1, right, ma, target, map);
    }

}
