package com.project.mapper;
import java.util.List;

import com.project.domain.OrderAddDTO;
import com.project.domain.OrderInfoDTO;
import com.project.domain.OrderMenuDTO;

public interface OrderMapper 
{
    void insertOrderMenu(OrderMenuDTO orderMenu);
    void insertOrderAdd(OrderAddDTO orderAdd);
    
    List<OrderMenuDTO> selectOrderMenus(int orderNumber);
    List<OrderAddDTO> selectOrderAdds(int orderNumber, int menuId);
    
    void insertOrderInfo(OrderInfoDTO orderInfo);
    
}
