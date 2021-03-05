package coke.cokeshop.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Order> orders;

}
