package ca.saultcollege.lab4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public abstract class PublicationEntity extends ProductEntity {

    @Column
    private String publisher;

    @Column
    private Integer yearPublished;

    // Constructors
    public PublicationEntity() {
    }

    public PublicationEntity(String name, Double price, String publisher, Integer yearPublished) {
        super(name, price);
        this.publisher = publisher;
        this.yearPublished = yearPublished;
    }

    // Getters and Setters
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "PublicationEntity{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", publisher='" + publisher + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}