package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.appclickup.entity.enums.SystemRoleName;
import uz.pdp.appclickup.entity.template.AbsUUIDEntity;

import java.util.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbsUUIDEntity implements UserDetails {
    private String fullName;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    private String color;
    private String initialLetter;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment avatar;

    private String emailCode;
    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private SystemRoleName systemRoleName;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(systemRoleName.name());
//         return List.of(simpleGrantedAuthority);
       return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public User(String fullName, String email, String password, SystemRoleName systemRoleName) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.systemRoleName = systemRoleName;
    }
}
