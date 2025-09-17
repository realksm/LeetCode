class FoodRatings {
    private record Food(String name, String cuisine, int rating) {}

    private final Map<String, Food> foods = new HashMap<>();
    private final Map<String, PriorityQueue<Food>> cuisineHeaps = new HashMap<>();

    public FoodRatings(String[] names, String[] cuisines, int[] ratings) {
        for (int i = 0; i < names.length; i++) {
            Food f = new Food(names[i], cuisines[i], ratings[i]);
            foods.put(names[i], f);
            cuisineHeaps
                .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                    (a, b) -> a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name)))
                .add(f);
        }
    }

    public void changeRating(String name, int newRating) {
        Food updated = new Food(name, foods.get(name).cuisine(), newRating);
        foods.put(name, updated);
        cuisineHeaps.get(updated.cuisine()).add(updated);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> heap = cuisineHeaps.get(cuisine);
        while (true) {
            Food top = heap.peek();
            if (foods.get(top.name()).rating() == top.rating()) return top.name();
            heap.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */