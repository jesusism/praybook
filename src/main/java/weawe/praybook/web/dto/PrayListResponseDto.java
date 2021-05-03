package weawe.praybook.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.Pray;


@Getter
@NoArgsConstructor
public class PrayListResponseDto {
    private Long id;
    private String prayType;
    private String prayTitle;
    private String prayContent;

    public PrayListResponseDto(Pray entity) {
        this.id = entity.getId();
        this.prayType = entity.getPrayType();
        this.prayTitle = entity.getPrayTitle();
        this.prayContent = entity.getPrayContent();
    }
}
