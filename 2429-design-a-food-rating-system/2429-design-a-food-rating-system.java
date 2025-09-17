class FoodRatings {
    static class Food {
        String name, cuisine;
        int rating;
        Food(String n, String c, int r) { name = n; cuisine = c; rating = r; }
    }

    private final Map<String, Food> foodMap = new HashMap<>();
    private final Map<String, PriorityQueue<Food>> cuisineToHeap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], f);
            cuisineToHeap
                .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                    (a, b) -> a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name)))
                .add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food updated = new Food(food, foodMap.get(food).cuisine, newRating);
        foodMap.put(food, updated);
        cuisineToHeap.get(updated.cuisine).add(updated);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineToHeap.get(cuisine);
        while (true) {
            Food top = pq.peek();
            if (foodMap.get(top.name).rating == top.rating) return top.name;
            pq.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */