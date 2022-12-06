package homework.ultimatemall;

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

    }


}
