package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weawe.praybook.domain.User;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String user_name;
    private String user_email;
    private int user_church;

    @Builder
    public UserSaveRequestDto(String user_name, String user_email, int user_church) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_church = user_church;
    }

    public User toEntity() {
        return User.builder()
                .user_name(user_name)
                .user_email(user_email)
                .user_church(user_church)
                .build();
    }

}
