package weawe.praybook.domain;

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
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_email;

    @Column(nullable = false)
    private int user_church;

    @OneToMany(mappedBy = "user")
    private List<Pray> prays = new ArrayList<>();

}
