class ProductOfNumbers {

    int total;
    int lastZero;
    List<Integer> current;

    public ProductOfNumbers() {
        this.total = 0;
        this.lastZero = 0;
        this.current = new ArrayList<>();
    }
    
    public void add(int num) {
        total++;
        if (num == 0) {
           lastZero = total;
           current.clear();
        } else {
            if (current.isEmpty()) current.add(num);
            else current.add(current.get(current.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        if (total - lastZero < k) return 0;
        if (k == current.size()) return current.get(current.size()-1);
        return current.get(current.size()-1) / current.get(current.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */