package liuxun.jpa.shard.entitys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_product")
public class Product implements Serializable {
    public Product() {
    }
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name; // 产品名称

    private Long stock; // 库存数量

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

}
