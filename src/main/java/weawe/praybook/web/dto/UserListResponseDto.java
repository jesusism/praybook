package weawe.praybook.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.User;


@Getter
@NoArgsConstructor
public class UserListResponseDto {
    private Long id;
    private String name;
    private String email;
    private String picture;

    public UserListResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
    }
}
