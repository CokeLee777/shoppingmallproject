package coke.cokeshop.dto.member;

import coke.cokeshop.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@AllArgsConstructor
public class MemberUpdateDto {

    private Long id;

    @NotEmpty(message = "회원 이름은 필수입니다")
    private String username;

    @NotEmpty(message = "이메일은 필수입니다")
    @Email(message = "이메일 형식으로 적어주세요")
    private String email;

    private String city;
    private String street;
    private String zipcode;
}
