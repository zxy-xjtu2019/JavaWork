import java.util.ArrayList;

import Item.Item;
import Item.ItemOrder;

public class ShopActivity {
    public static void addItem(Item item,ArrayList<Item> items){
        items.add(item);
    }
    public static void addOrder(ItemOrder order,ArrayList<ItemOrder> orders){
        orders.add(order);
        changeShoppingCar();
    }
    public static void changeShoppingCar(){

    }
    public static void addDiscount(){
        
    }
}