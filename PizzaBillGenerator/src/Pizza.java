public class Pizza {
    private int  price;

    private int basePizzPrice;
    private Boolean veg;

    private int ExtraCheesePrice= 100;

    private int ExtraToppingPrice= 150;

    private int backpackPrice = 20;

    private boolean isExtraCheese = false;;

    private boolean isExtraTooping = false;

    private boolean isTakeaway= false;

    public Pizza(Boolean veg){
        this.veg = veg;
        if(this.veg){
            this.price = 300;
        }
        else{
            this.price = 400;
        }
        basePizzPrice = this.price;
    }
   /*  public void getPizzaPrice(){
        System.out.println(this.price);
    }
    */
    public void addExtraCheese(){
        
        this.price += ExtraCheesePrice;
        isExtraCheese = true;
    }
    public void addExtraTopping(){
        
        this.price += ExtraToppingPrice;
        isExtraTooping = true;
    }
    public void takeAway(){
        
        this.price += backpackPrice;
        isTakeaway = true;
    }
    public void getBill(){  
        String bill ="";
        System.out.println("Pizza: "+ basePizzPrice);
        if(isExtraCheese){
            bill += "Extra Chesse added: " + ExtraCheesePrice +"\n";
        }
        if(isExtraTooping){
            bill += "Extra Topping added: " + ExtraToppingPrice +"\n";
        }
        if(isTakeaway){
            bill += "Takeaway Opted: " + backpackPrice +"\n";
            
        }
        bill += "Bill: " + this.price+"\n";
        System.out.println(bill);

    }

}
