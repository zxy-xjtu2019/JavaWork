package Item;

import Shop.ShopModel;

public class DiscountItem extends Item {
    int how,quntity;
    double discount;
    String name;
    public boolean ifRight = false;
    // how == 1 多卖则便宜
    // how == 2 打折促销
    //其余情况（相关联商品打折）有待讨论
    public void howToDiscount(){
        System.out.println("如何打折？（多买便宜输入1，单价打折输入2 ）");
            how = ShopModel.in.nextInt();
            if(how == 1){
                System.out.println("多少件一起卖打折？");
                this.quntity = ShopModel.in.nextInt();
                System.out.printf("%d件卖多少钱？\n",quntity);
                this.discount = ShopModel.in.nextDouble();
            }else if(how == 2){
                System.out.println("你要打多少折？（请输入数字，比如 95 ，即为打九五折）");
                int temp = ShopModel.in.nextInt();
                if(temp<10)temp *=10;
                if(temp<=0) System.out.println("请输入正数！");
                else {
                    this.discount = Double.valueOf(temp)/100;
                }
            }
    }
    public DiscountItem(int how,int quntity,double discount,String name){
        this.discount = discount;
        this.how = how;
        this.quntity = quntity;
        this.name = name;
        ifRight = true;
    }
    public DiscountItem(Store store){
        System.out.println("请输入打折的商品名称：");
        this.name = ShopModel.in.next();
        if(store.searchStore(this.name)==false){
            System.out.println("未找到相关产品！");
        }else if(store.searchDiscountStore(name)==true){
            System.out.printf("该商品折扣已经存在，折扣为%s",store.getDiscount(name));
            System.out.println("你是否要修改它呢？（修改请输入 1 ，不修改输入2 ）");
            int temp = ShopModel.in.nextInt();
            if(temp==1){
                store.changeDiscount(name,store);
                this.ifRight = true;
            }else if(temp!=2){
                System.out.println("输入错误，操作失败！");
            }
        }
        else{
            howToDiscount();
            this.ifRight = true;
        }
    }  
}