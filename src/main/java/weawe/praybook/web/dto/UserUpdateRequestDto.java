package weawe.praybook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String user_name;
    private String user_email;
    private String user_church;

    @Builder
    public UserUpdateRequestDto(String user_name, String user_email, String user_church) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_church = user_church;
    }
}
