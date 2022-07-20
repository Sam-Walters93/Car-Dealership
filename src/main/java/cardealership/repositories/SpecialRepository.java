package cardealership.repositories;

import cardealership.models.Special;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialRepository extends JpaRepository<Special, Integer> {
}
