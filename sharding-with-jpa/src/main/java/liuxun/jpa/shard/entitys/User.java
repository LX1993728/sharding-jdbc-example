package liuxun.jpa.shard.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
