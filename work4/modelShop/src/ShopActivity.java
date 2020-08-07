import java.util.ArrayList;
import java.util.Scanner;

import Item.DiscountItem;
import Item.Item;
import Item.ItemOrder;
import Item.Store;

public class ShopActivity {
    public static void addItem(Store store){
        Scanner in = new Scanner(System.in);
        Item item = new Item();
        System.out.print("请输入要加入的商品的名字：");
        String name = in.next();
        if(store.searchStore(name)){
            System.out.printf("该商品已经存在！零售价为%f\n",store.getPrice(name));
            System.out.println("你是否要修改它呢？（修改请输入 1 ，不修改输入2 ）");
            int temp = in.nextInt();
            if(temp==1){
                System.out.printf("请输入%s的新的价格:",name);
                store.changePrice(name,in.nextDouble());
            }else if(temp!=2){
                System.out.println("输入错误，操作失败！");
            }
        }else{
            item.name = name;
            System.out.print("请输入该商品的价格：");
            item.price = in.nextDouble();
            store.items.add(item);
            System.out.println("添加成功！");
        }
        in.close();
    }
    public static void addOrder(Store store){
        ItemOrder itemOrder = new ItemOrder(store);
        changeShoppingCar();
    }
    public static void changeShoppingCar(){

    }
    public static void addDiscount(Store store){
        DiscountItem discountItem = new DiscountItem(store);
        if(discountItem.ifRight == true){
            store.discountItems.add(discountItem);
        } 
    }
}