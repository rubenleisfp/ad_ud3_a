package ad.ud3_a.apiclient.domain;

import java.util.Objects;

public class Category {

    private String slug;
    private String name;
    private String url;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(slug, category.slug) && Objects.equals(name, category.name) && Objects.equals(url, category.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug, name, url);
    }

    @Override
    public String toString() {
        return "Category{" +
                "slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
