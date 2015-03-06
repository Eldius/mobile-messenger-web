package net.eldiosantos.viajabessa.model.auth;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by eldio.junior on 12/02/2015.
 */
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;
    private String password;
    private String email;

    private String registrationId;

    @Lob
    private String mobileDeviceKey;

    public Long getId() {
        return id;
    }

    public UserInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserInfo setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getMobileDeviceKey() {
        return mobileDeviceKey;
    }

    public void setMobileDeviceKey(String mobileDeviceKey) {
        this.mobileDeviceKey = mobileDeviceKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
