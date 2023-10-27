package com.project.mapper;
import com.project.domain.OrderMenu;
import com.project.domain.OrderAdd;
import com.project.domain.OrderInfoDTO;

import java.util.List;

public interface OrderMapper 
{
    void insertOrderMenu(OrderMenu orderMenu);
    void insertOrderAdd(OrderAdd orderAdd);
    
    List<OrderMenu> selectOrderMenus(int orderNumber);
    List<OrderAdd> selectOrderAdds(int orderNumber, int menuId);
    
    void insertOrderInfo(OrderInfoDTO orderInfo);
    
}
