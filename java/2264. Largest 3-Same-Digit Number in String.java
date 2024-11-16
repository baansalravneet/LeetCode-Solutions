class Solution {
    public String largestGoodInteger(String num) {
        if (num.indexOf("999") != -1) return "999";
        if (num.indexOf("888") != -1) return "888";
        if (num.indexOf("777") != -1) return "777";
        if (num.indexOf("666") != -1) return "666";
        if (num.indexOf("555") != -1) return "555";
        if (num.indexOf("444") != -1) return "444";
        if (num.indexOf("333") != -1) return "333";
        if (num.indexOf("222") != -1) return "222";
        if (num.indexOf("111") != -1) return "111";
        if (num.indexOf("000") != -1) return "000";
        return "";
    }
}
