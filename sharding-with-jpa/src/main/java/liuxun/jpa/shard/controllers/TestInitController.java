package liuxun.jpa.shard.controllers;

import liuxun.jpa.shard.entitys.Order;
import liuxun.jpa.shard.entitys.OrderItem;
import liuxun.jpa.shard.entitys.Product;
import liuxun.jpa.shard.entitys.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Random;

/**
 * @apiNote 初始化数据
 */
@RestController
@RequestMapping("/init")
public class TestInitController {
    private static final Logger logger = LoggerFactory.getLogger(TestInitController.class);

    @PersistenceContext
    private EntityManager em;

    @GetMapping("/data")
    @Transactional(propagation = Propagation.REQUIRED)
    public Object initData(){
        //  新建 10个用户  100 个商品 每个用户 订[1-10]个订单 每个订单[1-10]个订单项 每项数量5

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAddress(i % 2 == 0 ? "北京市海淀区-"+i:"北京市昌平区-"+i);
            user.setEmail(i % 2 == 0 ? "2652790899-"+i:"3501115-"+i);
            user.setUsername(i % 2 == 0 ? "张三-"+i:"李四-"+i);

            em.persist(user);
            // 每个用户订单数量[1-10] 每个订单包含订单项数量[1-10] 每个订单项的订购数量[1-10]

            // 首先创建10个商品 每个商品的库存量开始都是5000
            Long[] product_ids = new Long[10];
            for (int j = 0; j < 10 ; j++) {
                Product product = new Product();
                if (j < 3 ){
                     product.setName("热水壶-"+j);
                     product.setPrice(30.00 *j);
                 }else if( j >=3 && j < 6){
                    product.setName("格力空调-"+j);
                    product.setPrice(255.00 *j);
                 }else {
                    product.setName("苹果电脑-"+j);
                    product.setPrice(2543.00 *j);
                 }
                 product.setStock(5000L);
                 em.persist(product);
                 product_ids[j] = product.getProductId();
            }

            //  创建[1-10]之间随机个数的订单数量
            long orderNum = new Random().nextInt(10)+1;
            for (int j = 0; j < orderNum; j++) {
                Order order = new Order();
                // 随机获取订单项的数量
                long orderItemNum = new Random().nextInt(10)+1;
                for (int k = 0; k < orderItemNum; k++) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(new Product(product_ids[j]));
                    order.getOrderItems().add(orderItem);
                }
                order.setUser(user);
                em.persist(order);
            }

        }

        return "success";
    }


    public static void main(String[] args){
//        int Num=new Random().nextInt(10)+1;
//        new Random().nextInt(10)产生的是0-9的随机数
//        new Random().nextInt(11)产生的是0-10的随机数
//        所以要new Random().nextInt(10)+1；
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            logger.info(random.nextInt(10)+1+"");
        }
    }
}
