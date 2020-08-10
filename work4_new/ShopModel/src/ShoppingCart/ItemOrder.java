package ShoppingCart;

import Shop.Item;

public class ItemOrder {
    Item item = new Item();
    int quantity;//买多少件商品
    double cost;//一共花费

    public ItemOrder(Item item,int quantity){
        this.item = item;
        this.quantity = quantity;
        renewcost();
    }

    public void change(){

    }
    public void renewcost(){
        this.cost = this.item.discountPrice(quantity);
    }
}