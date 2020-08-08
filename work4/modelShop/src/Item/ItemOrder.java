package Item;

import java.util.Scanner;

import inter.ShowDetail;
import Shop.ShopModel;

public class ItemOrder implements ShowDetail{
    int quantity;
    String item;
    double cost;
    boolean ifRight = false;
    
    public ItemOrder(ShoppingCart ShoppingCart , Store store){
        System.out.print("请输入要购买的商品：");
        this.item = ShopModel.in.next();
        if(store.searchStore(this.item)==false){
            System.out.println("小店没有相应产品 嘤嘤嘤");
        }
        else if(ShoppingCart.searchShoppingCart(item) == true){
            System.out.printf("该商品订单已经存在，购买%d,花费%f元",ShoppingCart.getQuantityInCart(item),ShoppingCart.getCostInCart(item));
            System.out.println("您是否要更改？（修改请输入1，不修改输入2）");
            int temp = ShopModel.in.nextInt();
            if(temp == 1){
                ShoppingCart.changeOrder(item,store);
            }else if(temp!=2){
                System.out.println("输入错误！操作失败！");
            }
        }else{
            addOrder(store);
        }
    }

    public void addOrder(Store store){
        System.out.print("请输入要购买的数量：");
        this.quantity = ShopModel.in.nextInt();
        ifRight = true;
        this.cost = getMinMoney(store);
        System.out.println("加入购物车成功！");
    }
    public double getMinMoney(Store store){
        if(store.searchDiscountStore(item)==false) return quantity*store.items.get(store.getItem(item)).price;
        else {
            int index = store.getDiscountItem(item);
            if(store.discountItems.get(index).how==1){
                double ans = 0;
                int sum = this.quantity;
                while(sum>=store.discountItems.get(index).quntity){
                    ans += store.discountItems.get(index).discount;
                    sum -= store.discountItems.get(index).quntity;           
                }
                ans +=sum *store.items.get(store.getItem(item)).price;
                return ans;
            }else{
                return quantity*store.items.get(store.getItem(item)).price*store.discountItems.get(index).discount;
            }
        }
    }
    //get the cheapest
    public void showDetail(){
        System.out.printf("item : %s  quantity : %d\n",item,quantity);
    }
    
}