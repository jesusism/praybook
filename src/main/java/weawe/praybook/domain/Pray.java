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
    private String prayType;

    @Column(nullable = false)
    private String prayTitle;

    @Column(columnDefinition = "TEXT")
    private String prayContent;

    @Builder
    public Pray(String prayType, String prayTitle, String prayContent) {
        this.prayType = prayType;
        this.prayTitle = prayTitle;
        this.prayContent = prayContent;
    }

    public void update(String prayType, String prayTitle, String prayContent) {
        this.prayType = prayType;
        this.prayTitle = prayTitle;
        this.prayContent = prayContent;
    }

    //==연관관계 메서드==//
    public void setUser(User user) {
        this.user = user;
        //user.getPrays().add(this);
    }
}
