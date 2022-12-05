/**
 * @Author: Neo
 * @Date: 2022/12/05 星期一 17:22:53
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.dto;

import lombok.Data;

@Data
public class OrderDto extends CartDto {
    private Long addressId;

    private String orderId;
}