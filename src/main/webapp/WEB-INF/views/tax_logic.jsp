<%@ page import="java.math.BigInteger" %><%--
  Created by IntelliJ IDEA.
  User: PC Net Computers
  Date: 12/31/2022
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int b_sal = Math.toIntExact(Long.parseLong(request.getParameter("b_sal")));
    int rent = Math.toIntExact(Long.parseLong(request.getParameter("rent")));
    int med = Math.toIntExact(Long.parseLong(request.getParameter("med")));
    int conv = Math.toIntExact(Long.parseLong(request.getParameter("conv")));
    int bonus = Math.toIntExact(Long.parseLong(request.getParameter("bonus")));
    String catagory = request.getParameter("catagory") ;

    int result=0;
    int total =0;
    int d_conv = 0;
    int d_rent = 0;
    int d_med = 0;
    int tax_amount = 0;
    int taxable_amount =0;
    if(b_sal>=0 || rent>=0 || conv>=0 || bonus>=0|| med>=0){
        result = b_sal+rent+conv+med;
//                result = (b_sal*12) + (rent*12) + (conv*12) +(bonus*2) + (med*12);
        if(conv*12>30000){
            d_conv = (conv*12)-30000;
        }
        if(b_sal*6 >300000){
            d_rent= rent*12 - 300000;
        }else {
            d_rent = rent*12 - b_sal*6;
        }
        if(((b_sal*12)*10)/100 >120000){
            d_med = med*12-1200000;
        }else {
            d_med = med*12-((b_sal*12)*10)/100;
        }
        tax_amount = d_conv+d_med+d_rent+(bonus*2)+(b_sal*12);
    }
    taxable_amount = tax_amount;
    int tax_1 = 0;
    int tax_2 = 0;
    int tax_3 = 0;
    int tax_4 = 0;
    int tax_5 = 0;
    if(catagory.equals("General")){
        if (tax_amount > 300000) {
            tax_amount = tax_amount - 300000;

            if (tax_amount > 100000) {
                tax_amount = tax_amount - 100000;
                tax_1 = 100000 * 5 / 100;

                if (tax_amount > 300000) {
                    tax_amount = tax_amount - 300000;
                    tax_2 = 300000 * 10 / 100;

                    if (tax_amount > 400000) {
                        tax_amount = tax_amount - 400000;
                        tax_3 = 400000 * 15 / 100;

                        if (tax_amount > 500000) {
                            tax_amount = tax_amount - 500000;
                            tax_4 = 500000 * 20 / 100;

                            if (tax_amount >= 1) {
                                tax_5 = tax_amount * 25 / 100;
                            }
                        } else {
                            tax_4 = tax_amount * 20 / 100;
                        }
                    } else {
                        tax_3 = tax_amount * 15 / 100;
                    }
                } else {
                    tax_2 = tax_amount * 10 / 100;
                }
            } else {
                tax_1 = tax_amount * 5 / 100;
            }
        }
    }
    if(catagory.equals("Woman/OLD")){
        if (tax_amount > 350000) {
            tax_amount = tax_amount - 350000;

            if (tax_amount > 100000) {
                tax_amount = tax_amount - 100000;
                tax_1 = 100000 * 5 / 100;

                if (tax_amount > 300000) {
                    tax_amount = tax_amount - 300000;
                    tax_2 = 300000 * 10 / 100;

                    if (tax_amount > 400000) {
                        tax_amount = tax_amount - 400000;
                        tax_3 = 400000 * 15 / 100;

                        if (tax_amount > 500000) {
                            tax_amount = tax_amount - 500000;
                            tax_4 = 500000 * 20 / 100;

                            if (tax_amount >= 1) {
                                tax_5 = tax_amount * 25 / 100;
                            }
                        } else {
                            tax_4 = tax_amount * 20 / 100;
                        }
                    } else {
                        tax_3 = tax_amount * 15 / 100;
                    }
                } else {
                    tax_2 = tax_amount * 10 / 100;
                }
            } else {
                tax_1 = tax_amount * 5 / 100;
            }
        }
    }
    if(catagory.equals("Freedom Fighter")){
        if (tax_amount > 375000) {
            tax_amount = tax_amount - 375000;

            if (tax_amount > 100000) {
                tax_amount = tax_amount - 100000;
                tax_1 = 100000 * 5 / 100;

                if (tax_amount > 300000) {
                    tax_amount = tax_amount - 300000;
                    tax_2 = 300000 * 10 / 100;

                    if (tax_amount > 400000) {
                        tax_amount = tax_amount - 400000;
                        tax_3 = 400000 * 15 / 100;

                        if (tax_amount > 500000) {
                            tax_amount = tax_amount - 500000;
                            tax_4 = 500000 * 20 / 100;

                            if (tax_amount >= 1) {
                                tax_5 = tax_amount * 25 / 100;
                            }
                        } else {
                            tax_4 = tax_amount * 20 / 100;
                        }
                    } else {
                        tax_3 = tax_amount * 15 / 100;
                    }
                } else {
                    tax_2 = tax_amount * 10 / 100;
                }
            } else {
                tax_1 = tax_amount * 5 / 100;
            }
        }
    }


    int tax = tax_1+tax_2+tax_3+tax_4+tax_5;
%>
</body>
</html>
