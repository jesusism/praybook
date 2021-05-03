package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PrayUpdateRequestDto {

    private String prayType;
    private String prayTitle;
    private String prayContent;

    @Builder
    public PrayUpdateRequestDto(String prayType, String prayTitle, String prayContent) {
        this.prayType = prayType;
        this.prayTitle = prayTitle;
        this.prayContent = prayContent;
    }
}
