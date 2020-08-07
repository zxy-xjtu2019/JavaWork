import java.util.ArrayList;
import java.util.Iterator;

import Item.ItemOrder;
import inter.ShowDetail;

public class ShoppingCart implements ShowDetail{
    double count;
    ArrayList<ItemOrder> ShopCart = new ArrayList<ItemOrder>();

    public ShoppingCart(ItemOrder item){
        ShopCart.add(item);
    }


    public void showDetail(){
        Iterator<ItemOrder> iterator = ShopCart.iterator()>;
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}