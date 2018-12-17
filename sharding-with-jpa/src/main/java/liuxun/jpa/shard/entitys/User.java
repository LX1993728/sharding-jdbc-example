package liuxun.jpa.shard.entitys;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @apiNote 用户表
 * @author liuxun
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    public User() {
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username; // 用户名
    private String email; // 用户邮箱
    private String address; // 用户地址

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
