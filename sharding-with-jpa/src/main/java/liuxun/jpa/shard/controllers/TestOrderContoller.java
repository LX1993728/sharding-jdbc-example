package liuxun.jpa.shard.controllers;

import liuxun.jpa.shard.entitys.Order;
import liuxun.jpa.shard.repository.GeneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class TestOrderContoller {
    private static final Logger logger = LoggerFactory.getLogger(TestOrderContoller.class);

    @Autowired
    private GeneralService generalService;

    @GetMapping("/add")
    public Object add(Integer count){
        count= count==null?1:count;
        for (int i = 0; i < count; i++) {
            Order order = new Order();
            order.setTotal(100.0);
            generalService.persisent(order);
        }
        return "success";
    }
}
