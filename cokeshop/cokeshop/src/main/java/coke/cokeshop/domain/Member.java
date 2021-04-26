package coke.cokeshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 회원 엔티티
 * username: 회원 이름
 * password: 회원 비밀번호
 * email: 회원 이메일
 */
@Entity
@Getter @Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;
    private String password;
    private String email;

    @Embedded
    private Address address;

    //주문 엔티티와 1:N 관계
    @OneToMany(mappedBy = "member")
    private List<Order> orders;

    /**
     * 회원 생성 메서드
     */
    public static Member createMember(String username, String password, String email, Address address){

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        member.setAddress(address);

        return member;
    }

    /**
     * 회원 수정 메서드
     */
    public static void updateMember(Member member, String name, String email, Address address){
        member.setUsername(name);
        member.setEmail(email);
        member.setAddress(address);
    }

}
