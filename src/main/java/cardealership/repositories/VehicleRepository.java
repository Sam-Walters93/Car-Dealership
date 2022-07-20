package cardealership.repositories;

import cardealership.models.Make;
import cardealership.models.Model;
import cardealership.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByYear(int year);
    List<Vehicle> findByMake(Make make);
    List<Vehicle> findByModel(Model model);
    List<Vehicle> findBySalePrice(BigDecimal salePrice);
    List<Vehicle> findByYearAndMakeAndModel(int year, Make make, Model model);
}
