package ShopModel;

import java.util.Scanner;

import Shop.Shop;
import ShoppingCart.ShoppingCart;

public class ShopModel {
    public static Scanner in = new Scanner(System.in);
    public static Shop shop = new Shop();
    public static ShoppingCart shoppingCart = new ShoppingCart();
    public static void main(String[] args) throws Exception {
        String seletion;
        do{
            System.out.println("你想看看哪里？\n A Shop \n B ShoppingCart\n C exit");
            seletion = in.next();
            switch(seletion){
                case "A":
                    openShop();
                    break;
                case "B":
                    openCart();
                    break;
                case "C":
                    break;
                default :
                    System.out.println("没有这个选项！");
                    break;
            }
               
        }while(seletion.equals("C")==false);
        in.close();
    }
    public static void openShop(){
        String seletion;
        System.out.println("欢迎来到商城！");
        do{
            System.out.println("你想做什么？");
            System.out.println(" A 添加新的商品 \n B 删除商品\n C 看看有什么 \n D 我想买东西\n E 给一些商品打折\n F 告辞");
            seletion = in.next();
            switch(seletion){
                case "A":
                    shop.addItem();
                    break;
                case "B":
                    shop.deleteItem();
                    break;
                case "C":
                    shop.show();
                    break;
                case "D":
                    shop.buyItem();
                    break;
                case "E":
                    shop.discountItem();
                    break;
                case "F":
                    break;
                default:
                    System.out.println("不能做别的事情呢");
            }
        }while(seletion.equals("F")==false);
    }
    public static void openCart(){
        String seletion;
        System.out.println("来看看你的购物车吧！");
        shoppingCart.show();
        System.out.println("你想做些什么呢？\n A 再买点东西 \n B 有些东西我不想要了\n C 离开");
        seletion = in.next();
        switch(seletion){
            case "A":
                shop.show();
                shop.buyItem();
                break;
            case "B":
                shoppingCart.delete();
                break;
            case "C":
                break;
            default:
                System.out.println("选择错误哦！");
        }
    }
}
