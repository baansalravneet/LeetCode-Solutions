class Cashier {
    private int discount;
    private Map<Integer, Integer> productPrices;
    private int count;
    private int n;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.count = 0;
        this.discount = discount;
        this.productPrices = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            this.productPrices.put(products[i], prices[i]);
        }
        this.n = n;
    }
    
    public double getBill(int[] product, int[] amount) {
        this.count++;
        double total = 0;
        for (int i = 0; i < product.length; i++) {
            int price = this.productPrices.get(product[i]);
            int a = amount[i];
            total += price * a;
        }
        if (count % n == 0) {
            total *= (double)(100-this.discount)/100;
        }
        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
