class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> allA = findAll(s, a);
        if (allA.isEmpty()) return result;
        List<Integer> allB = findAll(s, b);
        if (allB.isEmpty()) return result;
        int i = 0;
        int j = 0;
        while (i < allA.size() && j < allB.size()) {
            while (j < allB.size() && allB.get(j) < allA.get(i) && allA.get(i) - allB.get(j) > k) j++;
            if (j < allB.size() && Math.abs(allA.get(i) - allB.get(j)) <= k) result.add(allA.get(i));
            i++;
        }
        return result;
    }
    private List<Integer> findAll(String s, String a) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while(index != -1){
            index = s.indexOf(a, index);
            if (index != -1) {
                result.add(index);
                index++;
            }
        }
        return result;
    }
}
