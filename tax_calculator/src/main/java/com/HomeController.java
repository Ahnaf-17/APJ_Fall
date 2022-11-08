package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;

@Controller

@RequestMapping("/home")
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    @RequestMapping({"calculator"})
    public String register() {

        return "Home";
    }


        @RequestMapping({"/result"})
            public String calculation(@ModelAttribute("b_sal") int b_sal,
                                      @ModelAttribute("rent") int rent,
                                      @ModelAttribute("med") int med,
                                      @ModelAttribute("conv") int conv,
                                      @ModelAttribute("bonus") int bonus,
//                                      @ModelAttribute("total") int total,
//
                                      Model model) throws SQLException {
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

//
//
            int tax = tax_1+tax_2+tax_3+tax_4+tax_5;
            model.addAttribute("tax", tax);
            model.addAttribute("result", result);
            model.addAttribute("taxable_amount", taxable_amount);

//            int tax = 0;
//            if(total<=50000){
////                System.out.println("no tax");
//            }else {
//                tax = (int) (total*.10);
////                System.out.println(tax);
//            }





            Connection connection = this.dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into tax( total_amount,texable_amount,tax) values (?,?,?)");
            statement.setString(1, String.valueOf(result));
            statement.setString(2, String.valueOf(taxable_amount));
            statement.setString(3, String.valueOf(tax));
//            statement.setString(1, tax);
//            statement.setString(2, String.valueOf(result));
            statement.execute();
            return "Home";


        }
}

