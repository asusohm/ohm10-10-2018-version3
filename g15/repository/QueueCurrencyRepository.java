package sut.sa.g15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.QueueCurrency;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public interface QueueCurrencyRepository extends JpaRepository<QueueCurrency, Long> {

}
