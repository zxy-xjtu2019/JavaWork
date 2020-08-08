package Item;

import java.util.ArrayList;
import java.util.Iterator;

import inter.ShowDetail;

public class ShoppingCart extends Store implements ShowDetail{
    double count;
    public ArrayList<ItemOrder> ShopCart = new ArrayList<ItemOrder>();

    public ShoppingCart(){
    }

    public int searchOrder(String item){
        for(int i=0;i<ShopCart.size();i++){
            if(ShopCart.get(i).item==item) return i;
        }
        return -1;
    }
    public void showDetail(){
        Iterator<ItemOrder> iterator = ShopCart.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public boolean searchShoppingCart(String item){
        if(searchOrder(item)==-1)return false;
        else return true;
    }
    public int getQuantityInCart(String item){
        return ShopCart.get(searchOrder(item)).quantity;
    }
    public double getCostInCart(String item){
        return ShopCart.get(searchOrder(item)).cost;
    }
    public void changeOrder(String item,Store store){
        int index = searchOrder(item);
        ShopCart.get(index).addOrder(store);
    }
    public void changeShoppingCart(){
        this.count = 0;
        for(int i=0;i<ShopCart.size();i++){
            this.count+=ShopCart.get(i).cost;
        }
    }
}