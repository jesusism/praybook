package weawe.praybook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Pray extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "pray_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; //사용자

    @Column(nullable = false)
    private String pray_type;

    @Column(nullable = false)
    private String pray_title;

    @Column(columnDefinition = "TEXT")
    private String pray_content;

    @Builder
    public Pray(String pray_type, String pray_title, String pray_content) {
        this.pray_type = pray_type;
        this.pray_title = pray_title;
        this.pray_content = pray_content;
    }

    public void update(String pray_type, String pray_title, String pray_content) {
        this.pray_type = pray_type;
        this.pray_title = pray_title;
        this.pray_content = pray_content;
    }

    //==연관관계 메서드==//
    public void setUser(User user) {
        this.user = user;
        user.getPrays().add(this);
    }
}
