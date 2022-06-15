package RP2021;

public class Aufgabe9 {
    public static void main(String[] args) {
        Item item = new Item("Test Item", 20);
        Rating rating = new Rating();
        System.out.println("num: " + rating.getNumberOfReviews(item));
        System.out.println("avg: " + rating.getAverageRating(item));
        rating.addReview(item, 5);
        rating.addReview(item, 7);
        rating.addReview(item, 3);
        rating.addReview(item, 9);
        rating.addReview(item, 10);
        System.out.println("num: " + rating.getNumberOfReviews(item));
        System.out.println("avg: " + rating.getAverageRating(item));

    }
}
