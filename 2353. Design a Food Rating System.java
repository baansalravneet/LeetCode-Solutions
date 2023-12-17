class FoodRatings {
    Map<String, Integer> foodRatings;
    Map<String, PriorityQueue<Pair>> cuisineFoods;
    Map<String, String> foodCuisines;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatings = new HashMap<>();
        cuisineFoods = new HashMap<>();
        foodCuisines = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            foodRatings.put(food, rating);
            cuisineFoods.computeIfAbsent(cuisine, k -> new PriorityQueue<>((a,b) -> {
                if (a.rating == b.rating) {
                    return a.food.compareTo(b.food);
                } else {
                    return b.rating - a.rating;
                }
            })).add(new Pair(food, rating));
            foodCuisines.put(food, cuisine);
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatings.put(food, newRating);
        String cuisine = foodCuisines.get(food);
        cuisineFoods.get(cuisine).add(new Pair(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        Pair food = cuisineFoods.get(cuisine).peek();
        while (foodRatings.get(food.food) != food.rating) {
            cuisineFoods.get(cuisine).poll();
            food = cuisineFoods.get(cuisine).peek();
        }
        return food.food;
    }
}

class Pair {
    String food;
    int rating;
    Pair(String food, int rating) {
        this.food = food;
        this.rating = rating;
    }
}
/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
