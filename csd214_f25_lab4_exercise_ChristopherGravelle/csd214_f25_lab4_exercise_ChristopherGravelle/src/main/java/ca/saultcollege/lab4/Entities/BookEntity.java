package ca.saultcollege.lab4.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK") // 1. Specifies the value for this subclass in the discriminator column
public class BookEntity extends ProductEntity {

    private String author;
    private String title;

    // Note: The 'price' field is removed as it's inherited from Product

    public BookEntity() {
        super();
    }

    public BookEntity(String name, double price, String author, String title) {
        super(name, price); // Call the parent constructor
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // equals() and hashCode() are inherited from Product and don't need to be overridden.
    // The parent implementation using the 'id' field is sufficient.

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", publisher='" + getPublisher() + '\'' +
                ", yearPublished=" + getYearPublished() +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}



