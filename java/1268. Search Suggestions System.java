class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> prod = Arrays.asList(products);
        Collections.sort(prod);
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String sub = searchWord.substring(0, i);
            prod = prod.stream().filter(s -> s.indexOf(sub) == 0).collect(Collectors.toList());
            List<String> add = new ArrayList<>();
            for (int j = 0; j < 3 && j < prod.size(); j++) {
                add.add(prod.get(j));
            }
            result.add(add);
        }
        return result;
    }
}

