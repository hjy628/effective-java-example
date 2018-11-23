package chap8;

import java.math.BigDecimal;

public class FloatAndDoubleDemo {

    //broken  - use flaotding point for monetary calculation
/*    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = .10; funds >= price; price+=.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought+" items bought.");
        System.out.println("Change: $"+funds);
    }*/


//use BigDecimal
        public static void main(String[] args) {
                final BigDecimal TEN_CENTS = new BigDecimal(".10");

            int itemsBought = 0;
            BigDecimal funds = new BigDecimal("1.00");
            for (BigDecimal price = TEN_CENTS;
                    funds.compareTo(price)>=0;
                    price = price.add(TEN_CENTS)){
                itemsBought++;
                funds = funds.subtract(price);
            }

            System.out.println(itemsBought+" items bought.");
            System.out.println("Money left over: $"+funds);


        }

}
