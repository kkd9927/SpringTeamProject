package com.project.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderInfoDTO 
{
    private int o_number;
    private int r_id;
    private String u_id;
    private String o_addr;
    private Date oDate;
    private int p_code;
    private int t_code;
    private int s_code;
    private int o_price;
    private String o_req;
}
