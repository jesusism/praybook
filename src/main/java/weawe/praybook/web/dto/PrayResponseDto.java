package weawe.praybook.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.Pray;


@Getter
@NoArgsConstructor
public class PrayResponseDto {
    private Long id;
    private String pray_type;
    private String pray_title;
    private String pray_content;

    public PrayResponseDto(Pray entity) {
        this.id = entity.getId();
        this.pray_type = entity.getPray_type();
        this.pray_title = entity.getPray_title();
        this.pray_content = entity.getPray_content();
    }
}
