package Shop;

import java.util.Scanner;


import Item.Store;
import Item.ShoppingCart;

public class ShopModel {
    public static Scanner in =new Scanner (System.in);
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println("商店已经就绪！购物车已经就绪！");
        String seletion;
        do{
            System.out.println("你想做些什么？");
            System.out.println("A 商场东西太少了！我要上货！> <");
            System.out.println("B 我要买东西！（豪横）");
            System.out.println("C 东西卖不出去了呜呜呜含泪甩卖");
            System.out.println("D 我破产了，这商店关了吧QwQ");
            System.out.println("请做出你的选择(大写哦)! A ? B ? C ? D ?");
            seletion = in.next();
            switch (seletion){
                case "A":
                    ShopActivity.addItem(store);
                    break;
                case "B":
                    ShopActivity.addOrder(shoppingCart, store);
                    break;
                case "C":
                    ShopActivity.addDiscount(store);
                    break;
                case "D":
                    break;
                default:
                    System.out.println("你的选择通往深渊，请重新选择！");
            }
        }while(seletion.equals("D")==false);
        in.close();
    }
 
}
