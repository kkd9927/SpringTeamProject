package com.project.service;

import java.util.ArrayList;
import java.util.List;

import com.project.domain.OrderAddDTO;
import com.project.domain.OrderInfoDTO;
import com.project.domain.OrderMenuDTO;

public interface OrderService 
{
    void addOrderMenu(OrderMenuDTO OrderMenuDTO);
    void addOrderAdd(OrderAddDTO OrderAddDTO);
    
    List<OrderMenuDTO> getOrderMenuList(int orderNumber);
    
    List<OrderAddDTO> getOrderAddList(int orderNumber, int menuId);
    
    void placeOrder(OrderInfoDTO orderInfo);
    
    int createOrder(OrderInfoDTO orderinfo);
    
    int caltotalPrice(List<OrderMenuDTO> OrderMenuDTOList, List<ArrayList<OrderAddDTO>> OrderAddDTOList);
}