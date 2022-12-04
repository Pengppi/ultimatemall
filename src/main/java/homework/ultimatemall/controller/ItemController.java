/**
 * @Author: Neo
 * @Date: 2022/12/04 星期日 23:05:41
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import homework.ultimatemall.common.R;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.service.ItemService;
import homework.ultimatemall.service.KindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private KindService kindService;

    @PostMapping("/add")
    public R<String> add(@RequestBody Item item) {
        itemService.save(item);
        return R.success("添加成功");
    }

    @GetMapping("/kindList")
    public R<List<Object>> getItemList() {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct item_kind");
        List<Object> objects = itemService.listObjs(queryWrapper);
        return R.success(objects);
    }
}
