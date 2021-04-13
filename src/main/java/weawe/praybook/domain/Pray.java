package weawe.praybook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Pray extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pray_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; //사용자

    @Column(nullable = false)
    private int pray_type;

    @Column(nullable = false)
    private String pray_title;

    @Column(columnDefinition = "TEXT")
    private String pray_content;

    //==연관관계 메서드==//
    public void setUser(User user) {
        this.user = user;
        user.getPrays().add(this);
    }
}
