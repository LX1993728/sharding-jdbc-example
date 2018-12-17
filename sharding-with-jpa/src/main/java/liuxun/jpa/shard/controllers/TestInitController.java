package liuxun.jpa.shard.controllers;

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

            // 首先创建10个商品
            for (int j = 0; j < 10 ; j++) {

            }

        }

        return "success";
    }

}
