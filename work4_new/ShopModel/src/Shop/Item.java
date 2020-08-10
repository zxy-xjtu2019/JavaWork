package Shop;

import ShopModel.ShopModel;

public class Item {
    String name;
    double price;
    Discount discount = new Discount();

    public Item(String name,double price){
        this.name = name;
        this.price = price;
    }
    public Item(){

    }
    public double discountPrice(int number){
        return discount.discountPrice(number,price);
    }
    public String getName(){
        return name;
    }
    public void getDiscount(){
        System.out.println("请选择你的打折方式：多买便宜请输入1，单品打折请输入2");
        discount.how = ShopModel.in.nextInt();
        if(discount.how == 1){
            System.out.print("请问购买多少件可以便宜：");
            discount.quantity = ShopModel.in.nextInt();
            System.out.printf("购买%d件的花费：",discount.quantity);
            discount.discount = ShopModel.in.nextDouble();
        }else if(discount.how == 2){
            System.out.print("请问你要打几折？（输入数字，如95代表打九五折）：");
            int temp = ShopModel.in.nextInt();
            if(temp<=0||temp>=100){
                System.out.println("输入有问题，修改打折失败");
                discount.how = 0;
            }else if(temp<10){
                discount.discount = (double)temp/10;
            }else {
                discount.discount = (double)temp/100;
            }
        }else{
            System.out.println("抱歉，你的选择暂不支持");
        }
    }
    public void changePrice(){
        System.out.print("请输入更改后的价格");
        this.price = ShopModel.in.nextDouble();
    }
}