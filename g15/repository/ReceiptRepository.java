package sut.sa.g15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g15.entity.Receipt;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
