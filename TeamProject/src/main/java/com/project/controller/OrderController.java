package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.domain.CartItem;
import com.project.domain.OrderAddDTO;
import com.project.domain.OrderInfoDTO;
import com.project.domain.OrderMenuDTO;
import com.project.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/menu/*")
@AllArgsConstructor
//@RequestMapping("/order")
public class OrderController 
{
    private final OrderService service;
    
    //1.담긴 메뉴를 세션에 저장하는 컨트롤러 (모달창의 담기)
    @PostMapping("/addToCart")
    public String addToCart(HttpSession session, @RequestBody CartItem cartItem) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) 
        {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        cart.add(cartItem);
        return "Item added to cart successfully";
    }
    
    //가게 밑에 페이지에서 주문하기
    //2.세션에서 CartDTO를 검색하여 주문을 완료CartDTO에서 받은 주문 정보를 OrderMenuDTO와 OrderAddDTO 객체에 담아서 저장하는 로직을 구현
    @PostMapping("/completeOrder")
    public ResponseEntity<?> completeOrder(HttpSession session) 
    {
        // 세션에서 카트 정보 검색
        CartItem cartDTO = (CartItem) session.getAttribute("cart");
        if (cartDTO == null) 
        {
            return ResponseEntity.badRequest().body("카트가 비어 있습니다.");
        }

        // OrderInfoDTO 객체 생성 및 필요한 정보 설정
        OrderInfoDTO orderInfo = new OrderInfoDTO();
        // 필요하다면 여기에 다른 주문 관련 정보를 설정할 수 있습니다.

        // 주문 정보 저장 및 주문 번호 생성
        int orderNumber = service.createOrder(orderInfo);

        // CartDTO에서 주문 메뉴 정보를 추출하고 저장합니다.
        OrderMenuDTO orderMenu = new OrderMenuDTO();
        orderMenu.setO_number(orderNumber);
        orderMenu.setM_id(cartDTO.getM_id());
        orderMenu.setM_num(cartDTO.getM_num());
        orderMenu.setM_price(cartDTO.getM_price()); // 메뉴 가격 설정
        service.addOrderMenu(orderMenu);

        // CartDTO에서 추가 메뉴 정보를 추출하고 저장합니다.
        for (int i = 0; i < cartDTO.getAddMenuIds().size(); i++) {
            OrderAddDTO orderAdd = new OrderAddDTO();
            orderAdd.setO_number(orderNumber);
            orderAdd.setM_id(cartDTO.getM_id());
            orderAdd.setA_id(cartDTO.getAddMenuIds().get(i));
            orderAdd.setA_number(cartDTO.getAddMenuNum().get(i));
            orderAdd.setA_price(cartDTO.getA_price().get(i)); // 추가 메뉴 가격 설정
            service.addOrderAdd(orderAdd);
        }

        // 세션에서 카트 정보 제거
        session.removeAttribute("cart");

        // 주문 번호를 응답으로 반환
        return ResponseEntity.ok(orderNumber);
    }
    
    //3. 담긴 메뉴 조회
    @GetMapping("/orderDetail/{orderNumber}")
    public String orderDetail(@PathVariable int orderNumber, Model model) 
    {
        // 주문 메뉴 정보 조회
        List<OrderMenuDTO> orderMenuList = service.getOrderMenuList(orderNumber);
        List<ArrayList<OrderAddDTO>> orderAddList = null;
        // 주문 추가 메뉴 정보 조회 (필요하다면)
        for(OrderMenuDTO menu : orderMenuList) {        	
        	int mId = menu.getM_id();
        	
        	orderAddList.add((ArrayList<OrderAddDTO>) service.getOrderAddList(orderNumber, mId));
        }

        int totalPrice = service.caltotalPrice(orderMenuList, orderAddList);
        
        // 모델에 데이터 추가
        model.addAttribute("orderMenuList", orderMenuList);
        model.addAttribute("orderAddList", orderAddList);
        model.addAttribute("totalPrice", totalPrice);

        return "order"; //order.jsp로 이동?
    }


}