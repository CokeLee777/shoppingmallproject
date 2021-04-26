package coke.cokeshop.dto.member;

import coke.cokeshop.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MemberListDto {

    private Long id;
    private String username;
    private String email;
    private Address address;
}
