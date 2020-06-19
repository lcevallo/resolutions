package com.lcevallo.springsecurity.resolutions.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "users")
@Table(name = "users", schema = "public")
public class User {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    @Column(name = "username", unique = true)
    String username;

    @NonNull
    String password;

    @NonNull
    Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<UserAuthority> userAuthorities = new ArrayList<>();

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.userAuthorities = new ArrayList<>(user.userAuthorities);
    }

    public void addAuthority(String authority) {
        this.userAuthorities.add(UserAuthority.builder().user(this).authority(authority).build());
    }

}
