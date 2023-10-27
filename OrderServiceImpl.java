package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.domain.OrderMenu;
import com.project.domain.OrderAdd;
import com.project.domain.OrderInfoDTO;
import com.project.mapper.OrderMapper;
import com.project.service.OrderService;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    
    private final OrderMapper orderMapper;

    @Override
    public void addOrderMenu(OrderMenu orderMenu) {
        orderMapper.insertOrderMenu(orderMenu);
    }

    @Override
    public void addOrderAdd(OrderAdd orderAdd) {
        orderMapper.insertOrderAdd(orderAdd);
    }
    
    @Override
    public List<OrderMenu> getOrderMenus(int orderNumber) {
        return orderMapper.selectOrderMenus(orderNumber);
    }

    @Override
    public List<OrderAdd> getOrderAdds(int orderNumber, int menuId) {
        return orderMapper.selectOrderAdds(orderNumber, menuId);
    }
    //최종주문
    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void placeOrder(OrderInfoDTO orderInfo) {
        orderMapper.insertOrderInfo(orderInfo);
    }
    
}