package liuxun.jpa.shard.entitys;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_order")
public class Orders implements Serializable {
    public Orders() {
    }
    @Id
    @Column(name = "order_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UserIdentityGenerator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(targetEntity =User.class)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "null",value = ConstraintMode.NO_CONSTRAINT))
    private User user;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column
    private Double total; // 总金额
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


}
