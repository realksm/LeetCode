class FoodRatings {
    private final Map<String, PriorityQueue<Object[]>> cuisineToHeap = new HashMap<>();
    private final Map<String, String> foodToCuisine = new HashMap<>();
    private final Map<String, Integer> foodToRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            cuisineToHeap
                .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                    (a, b) -> {
                        int ra = (int) a[0], rb = (int) b[0];
                        if (ra != rb) return rb - ra; // higher rating first
                        return ((String) a[1]).compareTo((String) b[1]); // lexicographically smaller first
                    }))
                .add(new Object[]{ratings[i], foods[i]});
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food, newRating);
        cuisineToHeap.get(cuisine).add(new Object[]{newRating, food}); // lazy add
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Object[]> heap = cuisineToHeap.get(cuisine);
        while (true) {
            Object[] top = heap.peek();
            int rating = (int) top[0];
            String food = (String) top[1];
            if (foodToRating.get(food) == rating) {
                return food;
            }
            heap.poll(); // remove stale entry
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */