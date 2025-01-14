package ad.ud3_a.apiclient.product.utils;

import ad.ud3_a.apiclient.product.domain.Dimensions;
import ad.ud3_a.apiclient.product.domain.Meta;
import ad.ud3_a.apiclient.product.domain.Product;
import ad.ud3_a.apiclient.product.domain.Review;

import java.util.Arrays;
import java.util.List;

public class MockUtils {

    public static Product getMockProduct() {
        Product product = getMockProductWithoutId();
        product.setId(1);
        return product;
    }

    public static Product getMockProductWithoutId() {
        Dimensions dimensions = new Dimensions();
        dimensions.setWidth(23.17);
        dimensions.setHeight(14.43);
        dimensions.setDepth(28.01);

        // Crear los objetos Review
        Review review1 = new Review();
        review1.setRating(2);
        review1.setComment("Very unhappy with my purchase!");
        review1.setDate("2024-05-23T08:56:21.618Z");
        review1.setReviewerName("John Doe");
        review1.setReviewerEmail("john.doe@x.dummyjson.com");

        Review review2 = new Review();
        review2.setRating(2);
        review2.setComment("Not as described!");
        review2.setDate("2024-05-23T08:56:21.618Z");
        review2.setReviewerName("Nolan Gonzalez");
        review2.setReviewerEmail("nolan.gonzalez@x.dummyjson.com");

        Review review3 = new Review();
        review3.setRating(5);
        review3.setComment("Very satisfied!");
        review3.setDate("2024-05-23T08:56:21.618Z");
        review3.setReviewerName("Scarlett Wright");
        review3.setReviewerEmail("scarlett.wright@x.dummyjson.com");

        List<Review> reviews = Arrays.asList(review1, review2, review3);

        // Crear el objeto Meta
        Meta meta = new Meta();
        meta.setCreatedAt("2024-05-23T08:56:21.618Z");
        meta.setUpdatedAt("2024-05-23T08:56:21.618Z");
        meta.setBarcode("9164035109868");
        meta.setQrCode("https://assets.dummyjson.com/public/qr-code.png");

        // Crear el objeto Product
        Product product = new Product();
        product.setTitle("Essence Mascara Lash Princess");
        product.setDescription("The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.");
        product.setCategory("beauty");
        product.setPrice(9.99);
        product.setDiscountPercentage(7.17);
        product.setRating(4.94);
        product.setStock(5);
        product.setTags(Arrays.asList("beauty", "mascara"));
        product.setBrand("Essence");
        product.setSku("RCH45Q1A");
        product.setWeight(2);
        product.setDimensions(dimensions);
        product.setWarrantyInformation("1 month warranty");
        product.setShippingInformation("Ships in 1 month");
        product.setAvailabilityStatus("Low Stock");
        product.setReviews(reviews);
        product.setReturnPolicy("30 days return policy");
        product.setMinimumOrderQuantity(24);
        product.setMeta(meta);
        product.setImages(Arrays.asList("https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/1.png"));
        product.setThumbnail("https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png");

        return product;
    }
}
