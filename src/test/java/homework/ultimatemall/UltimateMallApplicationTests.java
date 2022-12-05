package homework.ultimatemall;

import homework.ultimatemall.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class UltimateMallApplicationTests {

    @Autowired
    ItemService itemService;

    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("item_name", "上");
        map.put("item_kind", "distinct");
        log.info("result{}", itemService.listByMap(map));
    }

}
