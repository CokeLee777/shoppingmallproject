package coke.cokeshop.dto.member;

import coke.cokeshop.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MemberUpdateDto {

    private Long id;
    private String username;
    private String email;
    private String city;
    private String street;
    private String zipcode;
}
