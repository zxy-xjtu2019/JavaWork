public class Item {
    String name;
    double price;
    boolean ifRight = false;
    //ifRight to show whether it can be bought
    public Item(){
        this.name = "undefined";
        this.price = 0;
    }
    public Item(String name){
        this.name = name;
        this.price = 0;
    }
    public Item(String name,double price){
        this.name = name;
        this.price = price;
        this.ifRight = true;
    }
    //create new Item
    
}