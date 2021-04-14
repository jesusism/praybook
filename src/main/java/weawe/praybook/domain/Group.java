package weawe.praybook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
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
