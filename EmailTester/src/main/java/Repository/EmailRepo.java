package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entities.Email;
@Repository

public interface EmailRepo extends JpaRepository<Email, Long>{

	
}