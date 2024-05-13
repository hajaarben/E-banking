package ma.emsi.ebankingbackend2.repositories;

import ma.emsi.ebankingbackend2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
