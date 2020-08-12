package ShoppingCart;

import Shop.Item;
import Shop.Shop;

public class ItemOrder extends Shop{
    Item item = new Item();
    int quantity;//买多少件商品
    double cost;//一共花费

    public ItemOrder(Item item,int quantity){
        this.item = item;
        this.quantity = quantity;
        renewcost();
    }

    public void renewcost(){
        this.cost = this.item.discountPrice(quantity);
    }
}