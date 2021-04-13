package weawe.praybook.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import weawe.praybook.domain.posts.Posts;

import java.util.List;

public interface UserRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT u From User u ORDER BY u.user_id DESC")
    List<Posts> findAllDesc();
}
