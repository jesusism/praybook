package weawe.praybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import weawe.praybook.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u From User u ORDER BY u.user_id DESC")
    List<User> findAllDesc();
}
