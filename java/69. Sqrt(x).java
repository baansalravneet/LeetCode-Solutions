class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
       int left = 1, right = x;
       int answer = -1;
       while (left <= right) {
           long mid = (left + (right - left) / 2);
           if (mid*mid == (long)x) return (int)mid;
           if (mid*mid < (long)x) {
               answer = (int)mid;
               left = (int)mid + 1;
           } else {
               right = (int)mid - 1;
           }
       } 
       return answer;
    }
}
