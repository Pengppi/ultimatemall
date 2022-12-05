package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.ItemDao;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.service.ItemService;
import org.springframework.stereotype.Service;

/**
 * (Item)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 21:50:24
 */
@Service("itemService")
public class ItemServiceImpl extends ServiceImpl<ItemDao, Item> implements ItemService {

    @Override
    public void updateSellNum(Long itemId, Integer itemNum) {
        Item item = this.getById(itemId);
        item.setItemSell(item.getItemSell() + itemNum);
        this.updateById(item);
    }
}

