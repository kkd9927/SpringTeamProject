package com.project.domain;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

//담긴 메뉴들을 세션에 저장
public class MenuItemDTO
{
	private Long m_id;
	private int m_num;
	private double m_price;
	
	private Long a_id;
	private String a_name;
	private double a_price;
	private int a_quantity;  // 주문할 메뉴의 수량
	public OrderAddDTO[] getOrderAddList() {
		return null;
	}
    
}