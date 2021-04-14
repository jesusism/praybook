package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PrayUpdateRequestDto {

    private String pray_type;
    private String pray_title;
    private String pray_content;

    @Builder
    public PrayUpdateRequestDto(String pray_type, String pray_title, String pray_content) {
        this.pray_type = pray_type;
        this.pray_title = pray_title;
        this.pray_content = pray_content;
    }
}
