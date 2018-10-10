package sut.sa.g15.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g15.entity.Deposit;

@RepositoryRestController
@CrossOrigin(origins = "http;//localhost:4200")

public interface DepositRepository extends JpaRepository<Deposit, Long> {
    Deposit findByDepositAmount(Double depositAmount);
}
