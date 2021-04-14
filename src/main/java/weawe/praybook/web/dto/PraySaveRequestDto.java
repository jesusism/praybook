package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.Pray;


@Getter
@NoArgsConstructor
public class PraySaveRequestDto {

    private String pray_type;
    private String pray_title;
    private String pray_content;

    @Builder
    public PraySaveRequestDto(String pray_type, String pray_title, String pray_content) {
        this.pray_type = pray_type;
        this.pray_title = pray_title;
        this.pray_content = pray_content;
    }

    public Pray toEntity() {
        return Pray.builder()
                .pray_type(pray_type)
                .pray_title(pray_title)
                .pray_content(pray_content)
                .build();
    }
}
