package ad.ud3_a.apiclient.domain;

import java.util.Objects;

public class Review {
        private int rating;
        private String comment;
        private String date;
        private String reviewerName;
        private String reviewerEmail;

        // Getters and Setters

        public int getRating() {
                return rating;
        }

        public void setRating(int rating) {
                this.rating = rating;
        }

        public String getComment() {
                return comment;
        }

        public void setComment(String comment) {
                this.comment = comment;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getReviewerName() {
                return reviewerName;
        }

        public void setReviewerName(String reviewerName) {
                this.reviewerName = reviewerName;
        }

        public String getReviewerEmail() {
                return reviewerEmail;
        }

        public void setReviewerEmail(String reviewerEmail) {
                this.reviewerEmail = reviewerEmail;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Review review = (Review) o;
                return rating == review.rating && Objects.equals(comment, review.comment) && Objects.equals(date, review.date) && Objects.equals(reviewerName, review.reviewerName) && Objects.equals(reviewerEmail, review.reviewerEmail);
        }

        @Override
        public int hashCode() {
                return Objects.hash(rating, comment, date, reviewerName, reviewerEmail);
        }

        @Override
        public String toString() {
                return "Review{" +
                        "rating=" + rating +
                        ", comment='" + comment + '\'' +
                        ", date='" + date + '\'' +
                        ", reviewerName='" + reviewerName + '\'' +
                        ", reviewerEmail='" + reviewerEmail + '\'' +
                        '}';
        }
}