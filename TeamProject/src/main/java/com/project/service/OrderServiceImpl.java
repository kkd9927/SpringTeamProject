package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.OrderAddDTO;
import com.project.domain.OrderInfoDTO;
import com.project.domain.OrderMenuDTO;
import com.project.mapper.OrderMapper;
@Service
public class OrderServiceImpl implements OrderService {
    
    private final OrderMapper orderMapper;
    
    @Override
    public int createOrder(OrderInfoDTO orderInfo) 
    {
        orderMapper.insertOrderInfo(orderInfo);
        return orderInfo.getO_number();
    }
    
    @Override
    public void addOrderMenu(OrderMenuDTO orderMenu) {
        orderMapper.insertOrderMenu(orderMenu);
    }

    @Override
    public void addOrderAdd(OrderAddDTO orderAdd) {
        orderMapper.insertOrderAdd(orderAdd);
    }
    
    @Override
    public List<OrderMenuDTO> getOrderMenuList(int orderNumber) 
    {
        return orderMapper.selectOrderMenus(orderNumber);
    }

    @Override
    public List<OrderAddDTO> getOrderAddList(int orderNumber, int menuId) 
    {
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
    @Override
    public int caltotalPrice(List<OrderMenuDTO> orderMenuList, List<ArrayList<OrderAddDTO>> orderAddList) 
    {
        int totalSum = 0;

        // 주문 메뉴 가격 계산 (수량을 고려하지 않음)
        for (OrderMenuDTO orderMenu : orderMenuList) {
            totalSum += orderMenu.getM_price();
        }

        // 추가 메뉴 가격 계산
        for (ArrayList<OrderAddDTO> addList : orderAddList) {
        	for (OrderAddDTO orderAdd : addList) {        		
        		totalSum += orderAdd.getA_price() * orderAdd.getA_number();
        	}
        }

        return totalSum;
    }
}