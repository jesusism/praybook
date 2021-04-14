package weawe.praybook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_email;

    @Column(nullable = false)
    private String user_church;

    @OneToMany(mappedBy = "user")
    private List<Pray> prays = new ArrayList<>();

    @Builder
    public User(String user_name, String user_email, String user_church) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_church = user_church;
    }

    public void update(String user_name, String user_email, String user_church) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_church = user_church;
    }

}
