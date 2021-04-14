package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupUpdateRequestDto {
    private String group_name;

    @Builder
    public GroupUpdateRequestDto(String group_name) {
        this.group_name = group_name;
    }
}
