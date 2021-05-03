package weawe.praybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import weawe.praybook.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u From User u ORDER BY u.id DESC")
    List<User> findAllDesc();

    Optional<User> findByEmail(String email);
}
