class Solution {
    public double maxAmount
    (
        String initialCurrency,
        List<List<String>> pairs1,
        double[] rates1,
        List<List<String>> pairs2,
        double[] rates2
    ) {
        Map<String, Double> day1 = getRates(pairs1, rates1, initialCurrency);
        Map<String, Double> day2 = getRates(pairs2, rates2, initialCurrency);
        Double answer = 1.0;
        for (String k : day1.keySet()) {
            if (!day2.containsKey(k)) continue;
            answer = Math.max(answer, day1.get(k) / day2.get(k));
        }
        return answer;
    }

    private Map<String, Double> getRates(List<List<String>> pairs, double[] rates, String initialCurrency) {
        Map<String, Double> day = new HashMap<>();
        int n = pairs.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String currency1 = pairs.get(j).get(0);
                String currency2 = pairs.get(j).get(1);
                double rate = rates[j];
                if (currency1.equals(initialCurrency)) {
                    day.put(currency2, Math.max(day.getOrDefault(currency2, 0.0), rate));
                } else if (currency2.equals(initialCurrency)) {
                    day.put(currency1, Math.max(day.getOrDefault(currency1, 0.0), 1/rate));
                }
                if (day.containsKey(currency1)) {
                    double c2r = day.get(currency1) * rate;
                    c2r = Math.max(c2r, day.getOrDefault(currency2, 0.0));
                    day.put(currency2, c2r);
                }
                if (day.containsKey(currency2)) {
                    double c1r = day.get(currency2) * (1/rate);
                    c1r = Math.max(c1r, day.getOrDefault(currency1, 0.0));
                    day.put(currency1, c1r);
                }
            }
        }
        return day;
    }
}
