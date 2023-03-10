public class App {
    public static void main(String[] args) throws Exception {
       // Pizza basePizza = new Pizza(true);
         
       
       // basePizza.addExtraTopping();
        //basePizza.addExtraCheese();
        
        //basePizza.getBill();

        DeluxPizza dp = new DeluxPizza(false);
        dp.takeAway();
        dp.addExtraCheese();
        dp.addExtraTopping();
        dp.getBill();
    }
}
