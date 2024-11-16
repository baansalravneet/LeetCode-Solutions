class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] answer = new String[n];
        Arrays.fill(answer, "zzzzzzzzzzzzzzzzzzzzz");
        loop: for (int i = 0; i < n; i++) {
            for (int length = 1; length <= arr[i].length(); length++) {
                for (int j = 0; j + length <= arr[i].length(); j++) {
                    String check = arr[i].substring(j, j+length);
                    boolean flag = false;
                    for (int k = 0; k < n; k++) {
                        if (k == i) continue;
                        if (arr[k].indexOf(check) != -1) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag && check.compareTo(answer[i]) < 0) {
                        answer[i] = check;
                    }
                }
                if (!answer[i].equals("zzzzzzzzzzzzzzzzzzzzz")) continue loop;
            }
            answer[i] = "";
        }
        return answer;
    }
}