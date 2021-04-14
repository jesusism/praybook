package weawe.praybook.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.User;


@Getter
@NoArgsConstructor
public class UserListResponseDto {
    private Long id;
    private String user_name;
    private String user_email;
    private String user_church;

    public UserListResponseDto(User entity) {
        this.id = entity.getId();
        this.user_name = entity.getUser_name();
        this.user_email = entity.getUser_email();
        this.user_church = entity.getUser_church();
    }
}
