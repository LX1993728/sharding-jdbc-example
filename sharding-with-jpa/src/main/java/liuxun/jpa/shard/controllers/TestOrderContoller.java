package liuxun.jpa.shard.controllers;

import io.shardingsphere.api.HintManager;
import liuxun.jpa.shard.entitys.Orders;
import liuxun.jpa.shard.repository.GeneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/order")
public class TestOrderContoller {
    private static final Logger logger = LoggerFactory.getLogger(TestOrderContoller.class);

    @Autowired
    private GeneralService generalService;

    @PersistenceContext
    private EntityManager em;

    @GetMapping("/getOrdersByUserId")
    public Object getOrdersByUserId(Long userId){
        final List<Orders> resultList = em.createQuery("SELECT o FROM Orders o WHERE o.user.id=:userId", Orders.class)
                .setParameter("userId",userId)
                .getResultList();
        logger.info("++++++++ {}++++++++",resultList.size());
        return resultList;
    }

    @GetMapping("/range")
    public Object getOrdersByTotalRange(){
        List<Orders> list = em.createQuery("SELECT o FROM Orders o WHERE o.total BETWEEN 400.00 AND 2000.00", Orders.class).getResultList();
        logger.info("++++++++ {}++++++++",list.size());
        return list;
    }

    @GetMapping("/count")
    public Object getCountOfOrder(){
        TypedQuery<Orders> query = em.createQuery("SELECT o FROM Orders o ", Orders.class);

        List<Orders> resultList=query.getResultList();
        return resultList.size();
    }

    @GetMapping("/order")
    public Object getCountOfOrder(Long orderId){
//        final Orders orders = em.find(Orders.class, orderId);
//        return orders;

            TypedQuery<Orders> query = em.createQuery("SELECT o FROM Orders o where o.orderId=:orderId", Orders.class);
           query.setParameter("orderId",orderId);
            List<Orders> resultList=query.getResultList();
           return resultList;


    }

}
