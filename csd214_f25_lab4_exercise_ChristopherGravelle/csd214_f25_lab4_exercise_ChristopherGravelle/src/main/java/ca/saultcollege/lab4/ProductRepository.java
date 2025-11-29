package ca.saultcollege.lab4;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ProductRepository extends JpaRepository<Product, Long> {
    }
