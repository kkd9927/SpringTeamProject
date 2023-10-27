package com.project.service;

import com.project.domain.OrderMenu;
import com.project.domain.OrderAdd;
import com.project.domain.OrderInfoDTO;

import java.util.List;

public interface OrderService 
{
    void addOrderMenu(OrderMenu orderMenu);
    void addOrderAdd(OrderAdd orderAdd);
    
    List<OrderMenu> getOrderMenus(int orderNumber);
    List<OrderAdd> getOrderAdds(int orderNumber, int menuId);
    
    void placeOrder(OrderInfoDTO orderInfo);
    
}