package com.project.domain;
import lombok.Setter;
import lombok.Getter;
import java.util.List;

@Getter
@Setter

//담긴 메뉴들을 세션에 저장
public class CartItem 
{
    private int m_id;
    private int m_num;  // 주문할 메뉴의 수량
    private int m_price;
    
    private List<Integer> a_price;
    private List<Integer> addMenuIds;  // 추가 메뉴의 ID 리스트
    private List<Integer> addMenuNum;  // 추가 메뉴의 수량 리스트
    
}