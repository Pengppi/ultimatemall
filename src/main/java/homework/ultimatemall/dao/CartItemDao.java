package homework.ultimatemall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import homework.ultimatemall.entity.CartItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * (CartItem)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@Mapper
public interface CartItemDao extends BaseMapper<CartItem> {

}

