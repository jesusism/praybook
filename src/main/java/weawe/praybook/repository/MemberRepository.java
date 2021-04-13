package weawe.praybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import weawe.praybook.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m From Member m ORDER BY p.member_id DESC")
    List<Member> findAllDesc();
}
