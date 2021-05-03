package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.Pray;


@Getter
@NoArgsConstructor
public class PraySaveRequestDto {

    private String prayType;
    private String prayTitle;
    private String prayContent;

    @Builder
    public PraySaveRequestDto(String prayType, String prayTitle, String prayContent) {
        this.prayType = prayType;
        this.prayTitle = prayTitle;
        this.prayContent = prayContent;
    }

    public Pray toEntity() {
        return Pray.builder()
                .prayType(prayType)
                .prayTitle(prayTitle)
                .prayContent(prayContent)
                .build();
    }
}
