package liuxun.jpa.shard.entitys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_order_item")
public class OrderItem implements Serializable {
    public OrderItem() {
    }
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id", foreignKey = @ForeignKey(name = "null",value = ConstraintMode.NO_CONSTRAINT))
    private Product product;


    private Long count; // 订购数量

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
