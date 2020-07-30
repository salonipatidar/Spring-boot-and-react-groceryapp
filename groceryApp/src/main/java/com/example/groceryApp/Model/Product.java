package com.example.groceryApp.Model;

import javax.persistence.*;
//import javax.persistence.Transient;

import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rating;
    private int price;
    private String description;
    private int numReviews;
    private String images;
    private int cis;

    private Product() {}

    public Product(Long id,String name, String rating,int price, String description,int numReviews,String images,int cis) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.description = description;
        this.numReviews = numReviews;
        this.images = images;
        this.cis=cis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(rating, product.rating) &&
                Objects.equals(price,product.price) &&
                Objects.equals(description, product.description)&&
                Objects.equals(numReviews,product.numReviews)&&
                Objects.equals(images,product.images)&&
                Objects.equals(cis,product.cis);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, rating, price,description,numReviews,images,cis);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setFirstname(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getNumReviews() {
        return numReviews;
    }

    public int getCis() {
        return cis;
    }

    public void setCis(int cis) {
        this.cis = cis;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Rating='" + rating + '\'' +
                ", NumReviews='" +numReviews+'\''+
                ", Price='"+ price + '\''+
                ", description='" + description + '\'' +
                ", CountInStock = '"+cis+'\''+
                '}';
    }

}
