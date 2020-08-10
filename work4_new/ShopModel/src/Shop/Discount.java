package Shop;

public class Discount {
    int how,quantity;
    double discount;
    //how 标记打折的方式 0 不打折 1 多买便宜 2 价格便宜 其余情况暂不考虑  
    //quantity记录满足打折至少要买的件数
    // discount 表示打多少折 或者买quantity的花费
    public double discountPrice(int number,double price){
        if(how == 0){
            return number*price;
        }else if(how == 1){
            double sum = 0;
            int ans = number;
            while(ans>=quantity){
                ans -=quantity;
                sum += discount;
            }
            sum += ans*price;
            return sum;
        }else{
            return number*price*discount;
        }
    }
}