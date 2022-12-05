package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Order)表实体类
 *
 * @author makejava
 * @since 2022-12-04 21:49:53
 */
@SuppressWarnings("serial")
@Data
public class Order extends Model<Order> {

    private String orderId;

    private Long userId;

    private Long addressId;

    private BigDecimal orderAmount;

    private Integer orderState;

    private LocalDateTime orderTime;
}

