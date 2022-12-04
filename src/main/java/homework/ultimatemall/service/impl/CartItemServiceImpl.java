package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.CartItemDao;
import homework.ultimatemall.entity.CartItem;
import homework.ultimatemall.service.CartItemService;
import org.springframework.stereotype.Service;

/**
 * (CartItem)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@Service("cartItemService")
public class CartItemServiceImpl extends ServiceImpl<CartItemDao, CartItem> implements CartItemService {

}

