package sut.sa.g15.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g15.entity.ServiceCenter;
import sut.sa.g15.entity.Transaction;

import java.util.Collection;

@RepositoryRestController
@CrossOrigin(origins = "http;//localhost:4200")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Collection<Transaction> findByServiceCenterServiceCenID(Long serviceCenID);
}
