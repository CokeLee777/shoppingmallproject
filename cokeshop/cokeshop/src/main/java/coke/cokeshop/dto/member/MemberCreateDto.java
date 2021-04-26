package coke.cokeshop.dto.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class MemberCreateDto {

    @NotEmpty(message = "회원 이름은 필수입니다")
    private String username;

    @NotEmpty(message = "비밀번호는 필수입니다")
    @Size(min = 8, max = 20, message = "비밀번호는 8 ~ 20자 이하여야 합니다")
    private String password;

    @NotEmpty(message = "이메일은 필수입니다")
    @Email(message = "이메일 형식으로 적어주세요")
    private String email;

    private String city;
    private String street;
    private String zipcode;

}
