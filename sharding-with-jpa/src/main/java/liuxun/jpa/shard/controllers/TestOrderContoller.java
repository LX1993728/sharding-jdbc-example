package liuxun.jpa.shard.controllers;

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
        return resultList;
    }
}
