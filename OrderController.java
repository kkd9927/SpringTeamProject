package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.domain.OrderInfoDTO;
import com.project.domain.OrderMenu;
import com.project.domain.OrderAdd;
import com.project.service.OrderService;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 주문 담기
    @PostMapping("/addMenu")
    public String addOrderMenu(OrderMenu orderMenu) {
        orderService.addOrderMenu(orderMenu);
        return "redirect:/orderPage";
    }

    @PostMapping("/addOption")
    public String addOrderAdd(OrderAdd orderAdd) {
        orderService.addOrderAdd(orderAdd);
        return "redirect:/orderPage";
    }

    // 담긴 메뉴 조회
    @GetMapping("/viewOrder")
    public String viewOrder(@RequestParam("orderNumber") int orderNumber, Model model) {
        List<OrderMenu> orderMenus = orderService.getOrderMenus(orderNumber);
        model.addAttribute("orderMenus", orderMenus);

        for (OrderMenu orderMenu : orderMenus) {
            List<OrderAdd> orderAdds = orderService.getOrderAdds(orderNumber, orderMenu.getMenuId());
            model.addAttribute("orderAdds_" + orderMenu.getMenuId(), orderAdds);
        }
        return "orderView";
    }

    // 최종 주문
    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody OrderInfoDTO orderInfo) {
        orderService.placeOrder(orderInfo);
        return "redirect:/order/success";
    }
}