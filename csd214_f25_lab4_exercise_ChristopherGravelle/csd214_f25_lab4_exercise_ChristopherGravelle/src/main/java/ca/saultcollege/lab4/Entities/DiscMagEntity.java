package ca.saultcollege.lab4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DISCMAG")
public class DiscMagEntity extends MagazineEntity {

    @Column
    private String discContent;

    @Column
    private String discFormat;

    // Constructors
    public DiscMagEntity() {
    }

    public DiscMagEntity(String name, Double price, String publisher, Integer yearPublished,
                         Integer issueNumber, String frequency, String discContent, String discFormat) {
        super(name, price, publisher, yearPublished, issueNumber, frequency);
        this.discContent = discContent;
        this.discFormat = discFormat;
    }

    // Getters and Setters
    public String getDiscContent() {
        return discContent;
    }

    public void setDiscContent(String discContent) {
        this.discContent = discContent;
    }

    public String getDiscFormat() {
        return discFormat;
    }

    public void setDiscFormat(String discFormat) {
        this.discFormat = discFormat;
    }

    @Override
    public String toString() {
        return "DiscMagEntity{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", publisher='" + getPublisher() + '\'' +
                ", yearPublished=" + getYearPublished() +
                ", issueNumber=" + getIssueNumber() +
                ", frequency='" + getFrequency() + '\'' +
                ", discContent='" + discContent + '\'' +
                ", discFormat='" + discFormat + '\'' +
                '}';
    }
}