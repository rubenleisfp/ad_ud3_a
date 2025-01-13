package ad.ud3_a.apiclient.domain;

import java.util.List;
import java.util.Objects;

public class Product {
    private int id;
    private String title;
    private String description;
    private double price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
	public int hashCode() {
		return Objects.hash(brand, category, description, discountPercentage, id, images, price, rating, stock,
				thumbnail, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description)
				&& Double.doubleToLongBits(discountPercentage) == Double.doubleToLongBits(other.discountPercentage)
				&& id == other.id && Objects.equals(images, other.images)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating) && stock == other.stock
				&& Objects.equals(thumbnail, other.thumbnail) && Objects.equals(title, other.title);
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", discountPercentage=" + discountPercentage + ", rating=" + rating + ", stock=" + stock + ", brand="
				+ brand + ", category=" + category + ", thumbnail=" + thumbnail + ", images=" + images + "]";
	}
    
    
}