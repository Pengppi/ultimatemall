package homework.ultimatemall;

import homework.ultimatemall.entity.Order;
import homework.ultimatemall.entity.User;
import homework.ultimatemall.service.CartService;
import homework.ultimatemall.service.ItemService;
import homework.ultimatemall.service.OrderService;
import homework.ultimatemall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UltimateMallApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
        Long userId = 1599423857683345409L;
        //LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        //queryWrapper.eq(Cart::getUserId, userId);
        //List<Cart> cartList = cartService.list(queryWrapper);
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderId("1234");
        log.info("{}", order);
        orderService.updateById(order);

    }

    @Test
    void test1() {
        User u = new User();
        u.setUserName("test");
        u.setUserPassword("123456");
        u.setUserMail("123@abc.com");
        userService.save(u);
        log.info("user:{}", u);
    }

}
