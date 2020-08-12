package ShoppingCart;

import java.util.ArrayList;

import Shop.Shop;
import ShopModel.ShopModel;

public class ShoppingCart extends Shop{
    ArrayList<ItemOrder> Orders = new ArrayList<ItemOrder>();
    double sumOfOrders;
    
    public ShoppingCart(){

    }
    public void renewSum(){
        sumOfOrders = 0;
        for(int i=0;i<Orders.size();i++){
            sumOfOrders += Orders.get(i).cost;
        }
    }
    public void add(ItemOrder order){
        Orders.add(order);
        renewSum();
    }
    
    public void show(){
        if(Orders.isEmpty()){
            System.out.println("里面空空如也呢！");
            return;
        }
        for(int i=0;i<Orders.size();i++){
            System.out.printf("%s  %f\n",Orders.get(i).item.getName(),Orders.get(i).cost);
        }
        System.out.print("总计     ");
        System.out.println(sumOfOrders);
    }
    public int searchOrder(String name){
        for(int i=0;i<Orders.size();i++){
            if(Orders.get(i).item.getName().equals(name))return i;
        }
        return -1;
    }
    public void delete(){
        System.out.print("请输入你要删除的商品的名字： ");
        String name = ShopModel.in.next();
        int index = searchOrder(name);
        if(index==-1){
            System.out.println("该商品不在购物车中！");
        }else{
            Orders.remove(index);
            System.out.println("删除成功！");
        }
    }
}