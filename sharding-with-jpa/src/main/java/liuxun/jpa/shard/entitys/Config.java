package liuxun.jpa.shard.entitys;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * //TODO：目前不支持广播表
 * @apiNote 字典配置表，即在每个数据源中都需要存在的表
 */
//@Entity
//@Table(name = "t_config")
//public class Config implements Serializable {
//    public Config() {
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UserIdentityGenerator")
//    private Long id; //
//
//    @Column(length = 30)
//    private String name;
//
//    private String value;
//
//    private String description;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
