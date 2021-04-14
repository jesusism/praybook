package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.Group;


@Getter
@NoArgsConstructor
public class GroupSaveRequestDto {
    private String group_name;

    @Builder
    public GroupSaveRequestDto(String group_name) {
        this.group_name = group_name;
    }

    public Group toEntity() {
        return Group.builder()
                .group_name(group_name)
                .build();
    }

}
