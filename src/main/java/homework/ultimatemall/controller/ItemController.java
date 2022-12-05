/**
 * @Author: Neo
 * @Date: 2022/12/04 星期日 23:05:41
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import homework.ultimatemall.common.R;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public R<String> add(@RequestBody Item item) {
        itemService.save(item);
        return R.success("添加成功");
    }

    @PutMapping
    public R<String> update(@RequestBody Item item) {
        itemService.updateById(item);
        return R.success("修改成功");
    }

}
