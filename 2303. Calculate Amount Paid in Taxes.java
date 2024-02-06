class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int previous = 0;
        for (int[] bracket : brackets) {
            tax += (double)(Math.min(income, bracket[0]) - previous) * bracket[1] / 100;
            if (income <= bracket[0]) break;
            previous = bracket[0];
        }
        return tax;
    }
}
