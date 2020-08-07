package Item;

import java.util.ArrayList;

import Item.Item;

public class Store {
    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<DiscountItem> discountItems = new ArrayList<DiscountItem>();
    public Store(){
    }
    //
    public int getItem(String name){
        for(int i = 0;i<items.size();i++){
            if(name == items.get(i).name)return i;
        }
        return -1;
    }
    public boolean searchStore(String name){
        if(getItem(name)==-1) return false;
        else return true;
    }
    public double getPrice(String name){
        return items.get(getItem(name)).price;
    }
    public void changePrice(String name , double price){
        items.get(getItem(name)).price = price;
        System.out.println("修改成功！");
    }
    //对商品进行操作
    public int getDiscountItem(String name){
        for(int i=0;i<discountItems.size();i++){
            if(discountItems.get(i).name == name) return i;
        }
        return -1;
    }
    public boolean searchDiscountStore(String name){
        if(getDiscountItem(name)==-1) return false;
        else return true;
    }
    public String getDiscount(String name){
        int index = getDiscountItem(name);
        if(discountItems.get(index).how == 1) {
            return "买"+discountItems.get(index).quntity+"件"+name+"花费"+discountItems.get(index).discount;
        }else return "售价为原来的"+discountItems.get(index).discount*100+"%";
    }
    public void changeDiscount(String name,Store store){
        int index = getDiscountItem(name);
        discountItems.get(index).howToDiscount();

    }
    //对打折商品操作

}