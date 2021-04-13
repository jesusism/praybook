package weawe.praybook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Pray extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pray_id;

    @Column(nullable = false)
    private int pray_type;

    @Column(nullable = false)
    private String pray_title;

    @Column(columnDefinition = "TEXT")
    private String pray_content;


    @Builder
    public Pray(int pray_type, String pray_title, String pray_content) {
        this.pray_type = pray_type;
        this.pray_title = pray_title;
        this.pray_content = pray_content;
    }

    public void update(int pray_type, String pray_title, String pray_content) {
        this.pray_type = pray_type;
        this.pray_title = pray_title;
        this.pray_content = pray_content;
    }
}
