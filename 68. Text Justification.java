class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> groups = getGroups(words, maxWidth);
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < groups.size()-1; i++) {
            answer.add(justify(groups.get(i), maxWidth));
        }
        answer.add(justifyLeft(groups.get(groups.size()-1), maxWidth));
        return answer;
    }
    private String justifyLeft(List<String> group, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < group.size() - 1; i++) {
            sb.append(group.get(i) + " " );
        }
        sb.append(group.get(group.size()-1));
        while (sb.length() < maxWidth) sb.append(" ");
        return sb.toString();
    }
    private String justify(List<String> group, int maxWidth) {
        int spaceCount = getSpaceCount(group, maxWidth);
        List<String> spaceGrouping = getSpaceGrouping(spaceCount, group.size()-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < group.size()-1; i++) {
            sb.append(group.get(i));
            sb.append(spaceGrouping.get(i));
        }
        sb.append(group.get(group.size()-1));
        while (sb.length() != maxWidth) sb.append(" ");
        return sb.toString();
    }
    private List<String> getSpaceGrouping(int spaceCount, int groupCount) {
        if (groupCount == 0) return List.of(getSpace(spaceCount));
        int[] length = new int[groupCount];
        int i = 0;
        while (spaceCount != 0) {
            length[i % groupCount]++;
            i++;
            spaceCount--;
        }
        return getSpaces(length);
    }
    private List<String> getSpaces(int[] length) {
        List<String> result = new ArrayList<>();
        for (int i : length) {
            result.add(getSpace(i));
        }
        return result;
    }
    private String getSpace(int length) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() != length) sb.append(" ");
        return sb.toString();
    }
    private int getSpaceCount(List<String> group, int maxWidth) {
        int count = 0;
        for (String s : group) count += s.length();
        return maxWidth - count;
    }
    private List<List<String>> getGroups(String[] words, int maxWidth) {
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            List<String> current = new ArrayList<>();
            int charLength = 0;
            while (index < words.length && words[index].length()+charLength+current.size() <= maxWidth) {
                current.add(words[index]);
                charLength += words[index].length();
                index++;
            }
            result.add(current);
        }
        return result;
    } 
}
