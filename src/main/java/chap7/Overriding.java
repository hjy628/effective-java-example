package chap7;

public class Overriding {

    public static void main(String[] args) {

        Wine[] wines = {new Wine(),new SparklingWine(),new Champange()};
        for (Wine wine:wines){
            System.out.println(wine.name());
        }
    }

}



class Wine{
    String name() {return "wine";}
}

class SparklingWine extends Wine{
    @Override
    String name() {
        return "Spark ling ";
    }
}

class Champange extends SparklingWine{
    @Override
    String name() {
        return "champagne";
    }
}