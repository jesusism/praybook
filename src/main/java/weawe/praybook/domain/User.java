package weawe.praybook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_email;

    @Column(nullable = false)
    private int user_church;

    /*
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    */

    @Builder
    public User(String user_name, String user_email, int user_church) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_church = user_church;
    }

    public void update(String name, String email, int user_church) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_church = user_church;
    }
}
