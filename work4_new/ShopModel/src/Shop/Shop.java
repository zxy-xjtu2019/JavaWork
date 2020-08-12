package Shop;

import java.util.ArrayList;
import ShopModel.ShopModel;
import ShoppingCart.ItemOrder;

public class Shop {
    ArrayList<Item> items = new ArrayList<Item>();
    public Shop(){

    }
    private int searchItem(String name){
        for(int i=0;i<items.size();i++){
            if(items.get(i).name.equals(name))return i;
        }
        return -1;
    }

    public void addItem(){
        System.out.print("请输入你要添加的商品的名字：");
        String name = ShopModel.in.next();
        if(searchItem(name)!=-1){
            System.out.println("该商品已经存在！如果想修改其售价，请输入数字1,否则输入2");
            int temp = ShopModel.in.nextInt();
            if(temp == 1) items.get(searchItem(name)).changePrice();
            else if(temp != 2)System.out.println("选择错误！操作失败！");
        }
        System.out.print("请输入该商品的售价：");
        double price = ShopModel.in.nextDouble();
        Item item = new Item(name,price);
        items.add(item);
    }
    public void deleteItem(){
        System.out.print("请输入你要删除的商品的名字： ");
        String name = ShopModel.in.next();
        int index = searchItem(name);
        if(index==-1){
            System.out.println("该商品不在商城中！");
        }else{
            items.remove(index);
            System.out.println("删除成功！");
        }
    }

    public void show(){
        if(items.isEmpty()){
            System.out.println("里面空空如也呢！");
            return;
        }
        for(int i=0;i<items.size();i++){
            System.out.printf("%s  %f\n",items.get(i).name,items.get(i).price);
        }
    }
    public void buyItem(){
        System.out.println("你想购买什么？");
        String name = ShopModel.in.next();
        if(searchItem(name)==-1){
            System.out.println("商城中没有该物品！");
        }else if(ShopModel.shoppingCart.searchOrder(name)!=-1){
            System.out.println("该物品已经购买！详情请查看购物车！");
        }
        else{
            System.out.print("请问要购买多少件？");
            int quantity = ShopModel.in.nextInt();
            ItemOrder order = new ItemOrder(items.get(searchItem(name)),quantity);
            ShopModel.shoppingCart.add(order);
        }
    }
    public void discountItem(){
        System.out.println("请输入要打折的商品");
        String name = ShopModel.in.next();
        items.get(searchItem(name)).getDiscount();
    }
}