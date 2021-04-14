package weawe.praybook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    @Column(nullable = false)
    private String group_name;


    @Builder
    public Group(String group_name) {
        this.group_name = group_name;
    }

    public void update(String group_name) {
        this.group_name = group_name;
    }

}
