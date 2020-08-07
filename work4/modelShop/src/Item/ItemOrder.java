package Item;

import showdetail.ShowDetail;

public class ItemOrder implements ShowDetail{
    int quantity;
    String item;
    boolean ifRight = false;

    public ItemOrder(int quantity,String item){
        this.item = item;
        this.quantity = quantity;
        ifRight = true;
    }
    public ItemOrder(int quantity){
        this(quantity, "");
    }
    public ItemOrder(String item){
        this(0,item);
    }
    public ItemOrder(){
        this(0,"");
    }

    public double getMinMoney(){
        
        return 1.0;
    }
    //get the cheapest
    public void showDetail(){
        System.out.printf("item : %s  quantity : %d\n",item,quantity);
    }
    
}