public class ItemOrder {
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

    
}