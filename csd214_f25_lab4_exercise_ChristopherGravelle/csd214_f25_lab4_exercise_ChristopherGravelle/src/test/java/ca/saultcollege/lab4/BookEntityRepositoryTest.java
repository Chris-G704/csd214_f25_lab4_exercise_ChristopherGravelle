package ca.saultcollege.lab4.repositories;

import ca.saultcollege.lab4.entities.BookEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookEntityRepositoryTest {

    @Autowired
    private BookEntityRepository bookRepository;

    @BeforeEach
    void setUp() {
        // Clean the database before each test
        bookRepository.deleteAll();
    }

    @Test
    void testSaveAndRetrieveBook() {
        // Arrange
        BookEntity book = new BookEntity(
                "Test Book Title",
                29.99,
                "Test Publisher",
                2024,
                "Test Author",
                "978-0-123456-78-9"
        );

        // Act
        BookEntity savedBook = bookRepository.save(book);
        Optional<BookEntity> retrievedBook = bookRepository.findById(savedBook.getId());

        // Assert
        assertNotNull(savedBook.getId());
        assertTrue(retrievedBook.isPresent());
        assertEquals("Test Book Title", retrievedBook.get().getName());
        assertEquals("Test Author", retrievedBook.get().getAuthor());
        assertEquals(29.99, retrievedBook.get().getPrice());
        assertEquals("Test Publisher", retrievedBook.get().getPublisher());
        assertEquals(2024, retrievedBook.get().getYearPublished());
        assertEquals("978-0-123456-78-9", retrievedBook.get().getIsbn());
    }
}