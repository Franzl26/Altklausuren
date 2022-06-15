package RP2021;

import java.util.HashMap;

public class Rating {
    private HashMap<Item, Review> reviews = new HashMap<>();

    public int getNumberOfReviews(Item item) {
        Review r = reviews.get(item);
        return (r == null ? 0 : r.count);
    }

    public double getAverageRating(Item item) {
        Review r = reviews.get(item);
        return (r == null ? 0.0 : r.rating * 1.0 / r.count);
    }

    public void addReview(Item item, int rating) {
        if (item == null)
            throw new IllegalArgumentException("item must not be null!");
        if (rating < 0 || rating > 10)
            throw new IllegalArgumentException("Rating must be in [0, 10]!");
        Review r = reviews.get(item);
        if (r == null) reviews.put(item, new Review(1, rating));
        else reviews.put(item, new Review(r.count + 1, r.rating + rating));
    }

    private static class Review {
        int count = 0;
        long rating = 0;

        public Review(int count, long rating) {
            this.count = count;
            this.rating = rating;
        }
    }
}
