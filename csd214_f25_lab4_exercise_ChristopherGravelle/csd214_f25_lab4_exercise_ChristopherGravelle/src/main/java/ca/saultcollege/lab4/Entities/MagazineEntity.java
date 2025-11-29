package ca.saultcollege.lab4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MAGAZINE")
public class MagazineEntity extends PublicationEntity {

    @Column
    private Integer issueNumber;

    @Column
    private String frequency;

    // Constructors
    public MagazineEntity() {
    }

    public MagazineEntity(String name, Double price, String publisher, Integer yearPublished, Integer issueNumber, String frequency) {
        super(name, price, publisher, yearPublished);
        this.issueNumber = issueNumber;
        this.frequency = frequency;
    }

    // Getters and Setters
    public Integer getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "MagazineEntity{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", publisher='" + getPublisher() + '\'' +
                ", yearPublished=" + getYearPublished() +
                ", issueNumber=" + issueNumber +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}