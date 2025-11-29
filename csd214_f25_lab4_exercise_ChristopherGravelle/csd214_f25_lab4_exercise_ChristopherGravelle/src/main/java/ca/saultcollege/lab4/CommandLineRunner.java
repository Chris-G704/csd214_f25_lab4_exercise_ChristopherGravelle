package ca.saultcollege.lab4;

import ca.saultcollege.lab4.entities.*;
import ca.saultcollege.lab4.repositories.*;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class Lab4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

    @Bean
    public CommandLineRunner run(BookEntityRepository bookRepo,
                                 MagazineEntityRepository magazineRepo,
                                 DiscMagEntityRepository discMagRepo,
                                 TicketEntityRepository ticketRepo) {
        return args -> {
            Faker faker = new Faker();

            System.out.println("\n========== CRUD OPERATIONS FOR BOOK ENTITY ==========\n");

            // CREATE Book
            System.out.println("--- CREATE: Creating a new Book ---");
            BookEntity book = new BookEntity(
                    faker.book().title(),
                    faker.number().randomDouble(2, 10, 50),
                    faker.book().publisher(),
                    faker.number().numberBetween(2000, 2024),
                    faker.book().author(),
                    faker.code().isbn13()
            );
            BookEntity savedBook = bookRepo.save(book);
            System.out.println("Saved Book: " + savedBook);

            // READ Book
            System.out.println("\n--- READ: Retrieving the Book by ID ---");
            Optional<BookEntity> retrievedBook = bookRepo.findById(savedBook.getId());
            retrievedBook.ifPresent(b -> System.out.println("Retrieved Book: " + b));

            System.out.println("\n--- READ: Finding all Books ---");
            bookRepo.findAll().forEach(b -> System.out.println("Book: " + b));

            // UPDATE Book
            System.out.println("\n--- UPDATE: Modifying the Book's price ---");
            if (retrievedBook.isPresent()) {
                BookEntity bookToUpdate = retrievedBook.get();
                bookToUpdate.setPrice(bookToUpdate.getPrice() + 10.0);
                BookEntity updatedBook = bookRepo.save(bookToUpdate);
                System.out.println("Updated Book: " + updatedBook);
            }

            // DELETE Book
            System.out.println("\n--- DELETE: Deleting the Book ---");
            bookRepo.deleteById(savedBook.getId());
            System.out.println("Book deleted. Verifying deletion...");
            Optional<BookEntity> deletedBook = bookRepo.findById(savedBook.getId());
            System.out.println("Book exists after deletion: " + deletedBook.isPresent());

            System.out.println("\n========== CRUD OPERATIONS FOR MAGAZINE ENTITY ==========\n");

            // CREATE Magazine
            System.out.println("--- CREATE: Creating a new Magazine ---");
            MagazineEntity magazine = new MagazineEntity(
                    faker.company().name() + " Magazine",
                    faker.number().randomDouble(2, 5, 15),
                    faker.company().name() + " Publishing",
                    faker.number().numberBetween(2010, 2024),
                    faker.number().numberBetween(1, 100),
                    faker.options().option("Weekly", "Monthly", "Quarterly")
            );
            MagazineEntity savedMagazine = magazineRepo.save(magazine);
            System.out.println("Saved Magazine: " + savedMagazine);

            // READ Magazine
            System.out.println("\n--- READ: Retrieving the Magazine by ID ---");
            Optional<MagazineEntity> retrievedMagazine = magazineRepo.findById(savedMagazine.getId());
            retrievedMagazine.ifPresent(m -> System.out.println("Retrieved Magazine: " + m));

            System.out.println("\n--- READ: Finding all Magazines ---");
            magazineRepo.findAll().forEach(m -> System.out.println("Magazine: " + m));

            // UPDATE Magazine
            System.out.println("\n--- UPDATE: Modifying the Magazine's issue number ---");
            if (retrievedMagazine.isPresent()) {
                MagazineEntity magazineToUpdate = retrievedMagazine.get();
                magazineToUpdate.setIssueNumber(magazineToUpdate.getIssueNumber() + 1);
                MagazineEntity updatedMagazine = magazineRepo.save(magazineToUpdate);
                System.out.println("Updated Magazine: " + updatedMagazine);
            }

            // DELETE Magazine
            System.out.println("\n--- DELETE: Deleting the Magazine ---");
            magazineRepo.deleteById(savedMagazine.getId());
            System.out.println("Magazine deleted. Verifying deletion...");
            Optional<MagazineEntity> deletedMagazine = magazineRepo.findById(savedMagazine.getId());
            System.out.println("Magazine exists after deletion: " + deletedMagazine.isPresent());

            System.out.println("\n========== CRUD OPERATIONS FOR DISCMAG ENTITY ==========\n");

            // CREATE DiscMag
            System.out.println("--- CREATE: Creating a new DiscMag ---");
            DiscMagEntity discMag = new DiscMagEntity(
                    "Tech World DiscMag",
                    faker.number().randomDouble(2, 8, 20),
                    "Digital Publishing Co.",
                    faker.number().numberBetween(2015, 2024),
                    faker.number().numberBetween(1, 50),
                    "Monthly",
                    "Software demos and tutorials",
                    faker.options().option("CD", "DVD", "Blu-ray")
            );
            DiscMagEntity savedDiscMag = discMagRepo.save(discMag);
            System.out.println("Saved DiscMag: " + savedDiscMag);

            // READ DiscMag
            System.out.println("\n--- READ: Retrieving the DiscMag by ID ---");
            Optional<DiscMagEntity> retrievedDiscMag = discMagRepo.findById(savedDiscMag.getId());
            retrievedDiscMag.ifPresent(d -> System.out.println("Retrieved DiscMag: " + d));

            System.out.println("\n--- READ: Finding all DiscMags ---");
            discMagRepo.findAll().forEach(d -> System.out.println("DiscMag: " + d));

            // UPDATE DiscMag
            System.out.println("\n--- UPDATE: Modifying the DiscMag's disc format ---");
            if (retrievedDiscMag.isPresent()) {
                DiscMagEntity discMagToUpdate = retrievedDiscMag.get();
                discMagToUpdate.setDiscFormat("USB Drive");
                DiscMagEntity updatedDiscMag = discMagRepo.save(discMagToUpdate);
                System.out.println("Updated DiscMag: " + updatedDiscMag);
            }

            // DELETE DiscMag
            System.out.println("\n--- DELETE: Deleting the DiscMag ---");
            discMagRepo.deleteById(savedDiscMag.getId());
            System.out.println("DiscMag deleted. Verifying deletion...");
            Optional<DiscMagEntity> deletedDiscMag = discMagRepo.findById(savedDiscMag.getId());
            System.out.println("DiscMag exists after deletion: " + deletedDiscMag.isPresent());

            System.out.println("\n========== CRUD OPERATIONS FOR TICKET ENTITY ==========\n");

            // CREATE Ticket
            System.out.println("--- CREATE: Creating a new Ticket ---");
            TicketEntity ticket = new TicketEntity(
                    faker.artist().name() + " Concert Ticket",
                    faker.number().randomDouble(2, 50, 200),
                    faker.artist().name() + " Live Concert",
                    LocalDate.now().plusDays(faker.number().numberBetween(30, 365)),
                    faker.address().cityName() + " Arena"
            );
            TicketEntity savedTicket = ticketRepo.save(ticket);
            System.out.println("Saved Ticket: " + savedTicket);

            // READ Ticket
            System.out.println("\n--- READ: Retrieving the Ticket by ID ---");
            Optional<TicketEntity> retrievedTicket = ticketRepo.findById(savedTicket.getId());
            retrievedTicket.ifPresent(t -> System.out.println("Retrieved Ticket: " + t));

            System.out.println("\n--- READ: Finding all Tickets ---");
            ticketRepo.findAll().forEach(t -> System.out.println("Ticket: " + t));

            // UPDATE Ticket
            System.out.println("\n--- UPDATE: Modifying the Ticket's venue ---");
            if (retrievedTicket.isPresent()) {
                TicketEntity ticketToUpdate = retrievedTicket.get();
                ticketToUpdate.setVenue("Updated " + ticketToUpdate.getVenue());
                TicketEntity updatedTicket = ticketRepo.save(ticketToUpdate);
                System.out.println("Updated Ticket: " + updatedTicket);
            }

            // DELETE Ticket
            System.out.println("\n--- DELETE: Deleting the Ticket ---");
            ticketRepo.deleteById(savedTicket.getId());
            System.out.println("Ticket deleted. Verifying deletion...");
            Optional<TicketEntity> deletedTicket = ticketRepo.findById(savedTicket.getId());
            System.out.println("Ticket exists after deletion: " + deletedTicket.isPresent());

            System.out.println("\n========== ALL CRUD OPERATIONS COMPLETED ==========\n");
        };
    }
}