package ca.saultcollege.lab4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("TICKET")
public class TicketEntity extends ProductEntity {

    @Column
    private String eventName;

    @Column
    private LocalDate eventDate;

    @Column
    private String venue;

    // Constructors
    public TicketEntity() {
    }

    public TicketEntity(String name, Double price, String eventName, LocalDate eventDate, String venue) {
        super(name, price);
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.venue = venue;
    }

    // Getters and Setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", venue='" + venue + '\'' +
                '}';
    }
}