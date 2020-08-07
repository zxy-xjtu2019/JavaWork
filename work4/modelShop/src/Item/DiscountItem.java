package Item;

import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

public class DiscountItem extends Item {
    int how,quntity;
    double discount;
    // how == 1 多卖则便宜
    // how == 2 打折促销
    //其余情况（相关联商品打折）有待讨论
    public DiscountItem(){
        System.out.println("请输入打折的商品名称：");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        if()
        
    }  
}