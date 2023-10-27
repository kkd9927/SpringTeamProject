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
    private int oNum;
    private int rId;
    private String uId;
    private String oAddr;
//    private Date oDate;
    private int pCode;
    private int tCode;
    private int sCode;
    private int oTprice;
    private String oReq;
}
