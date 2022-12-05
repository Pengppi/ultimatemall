/**
 * @Author: Neo
 * @Date: 2022/12/05 星期一 15:52:43
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import homework.ultimatemall.common.R;
import homework.ultimatemall.dto.CartDto;
import homework.ultimatemall.entity.Cart;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.service.CartService;
import homework.ultimatemall.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;


    @GetMapping("/add/{itemId}")
    public R<String> add(@PathVariable Long itemId, HttpSession session) {
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        Long userId = (Long) session.getAttribute("userId");
        queryWrapper.eq(Cart::getUserId, userId);
        queryWrapper.eq(Cart::getItemId, itemId);
        Cart cart = cartService.getOne(queryWrapper);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cart.setItemId(itemId);
            cart.setItemNum(1);
            cartService.save(cart);
        } else {
            cart.setItemNum(cart.getItemNum() + 1);
            cartService.updateById(cart);
        }
        return R.success("添加成功");
    }

    @PutMapping("/{itemId}")
    public R<String> update(@PathVariable Long itemId, HttpSession session) {
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        Long userId = (Long) session.getAttribute("userId");
        queryWrapper.eq(Cart::getUserId, userId);
        queryWrapper.eq(Cart::getItemId, itemId);
        Cart cart = cartService.getOne(queryWrapper);
        if (cart == null) {
            return R.error("购物车中没有该商品");
        } else {
            int num = cart.getItemNum();
            if (num == 1) {
                cartService.removeById(cart);
            } else {
                cart.setItemNum(num - 1);
                cartService.updateById(cart);
            }
        }
        return R.success("修改成功");
    }


    @DeleteMapping
    public R<String> clearAll(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        cartService.remove(queryWrapper);
        return R.success("清空成功");
    }

    @GetMapping("/list")
    public R<CartDto> list(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        //Long userId=1599424913846833153L;
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUserId, userId);
        List<Cart> carts = cartService.list(queryWrapper);
        BigDecimal totalPrice = new BigDecimal(0);
        List<Item> items = new ArrayList<>();
        for (Cart cart : carts) {
            Long itemId = cart.getItemId();
            Item item = itemService.getById(itemId);
            item.setItemNum(cart.getItemNum());
            totalPrice = totalPrice.add(item.getItemPrice().multiply(new BigDecimal(item.getItemNum())));
            items.add(item);
        }
        CartDto cartDto = new CartDto();
        cartDto.setAmount(totalPrice);
        cartDto.setItems(items);
        return R.success(cartDto);
    }
}
