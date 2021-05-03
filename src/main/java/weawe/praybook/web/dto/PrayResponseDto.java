package weawe.praybook.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.Pray;


@Getter
@NoArgsConstructor
public class PrayResponseDto {
    private Long id;
    private String prayType;
    private String prayTitle;
    private String prayContent;

    public PrayResponseDto(Pray entity) {
        this.id = entity.getId();
        this.prayType = entity.getPrayType();
        this.prayTitle = entity.getPrayTitle();
        this.prayContent = entity.getPrayContent();
    }
}
