package sut.sa.g15.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g15.entity.ExchangeRate;

import java.util.Collection;
import java.util.Date;

@RepositoryRestController
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {


    Collection<ExchangeRate> findByDate(Date date);
}
