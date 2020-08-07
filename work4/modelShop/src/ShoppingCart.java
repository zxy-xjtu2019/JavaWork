import java.util.ArrayList;
import java.util.Iterator;

import Item.ItemOrder;
import showdetail.ShowDetail;

public class ShoppingCart implements ShowDetail{
    double count;
    ArrayList ShopCart = new ArrayList<ItemOrder>();

    public ShoppingCart(ItemOrder item){
        ShopCart.add(item);
        this.count+= item.getMinMoney();
    }


    public void showDetail(){
        Iterator<ItemOrder> iterator = ShopCart.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}