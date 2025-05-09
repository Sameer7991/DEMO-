package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Email;

public interface EmailRepo extends JpaRepository<Email, Long> {

}
