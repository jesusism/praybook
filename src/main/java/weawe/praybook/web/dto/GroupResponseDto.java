package weawe.praybook.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.Group;

@Getter
@NoArgsConstructor
public class GroupResponseDto {
    private Long id;
    private String group_name;

    public GroupResponseDto(Group entity) {
        this.id = entity.getId();
        this.group_name = entity.getGroup_name();
    }
}
