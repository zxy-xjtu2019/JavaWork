package Item;

import java.util.Scanner;

import inter.ShowDetail;

public class ItemOrder implements ShowDetail{
    int quantity;
    String item;
    double cost;
    boolean ifRight = false;

    public ItemOrder(int quantity,String item,Store store){
        this.item = item;
        this.quantity = quantity;
        ifRight = true;
        this.cost = getMinMoney(store);
    }
    public ItemOrder(Store store){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入要购买的商品：");
        item = in.next();
        if()
        in.close();
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