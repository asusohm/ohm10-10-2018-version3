package sut.sa.g15.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g15.entity.Withdraw;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")

public interface WithdrawRepository extends JpaRepository<Withdraw, Long> {
    Withdraw findByWithdrawAmount(Double withdrawAmount);

}
