package chap2;

//Builder Pattern
public class NutritionFactsWithBuilder {
    private final int servomgSize;  //(mL)  required
    private final int servings;  //(per container)  required
    private final int calories;  //   optional
    private final int fat;  // (g)  optional
    private final int sodium;  //(mg)   optional
    private final int carbohydrate;  //(g)   optional

    public static class Builder{
        //Required parameters
        private final int servomgSize;
        private final int servings;

        //Optional parameters -initialized to default values
        private  int calories = 0;
        private  int fat = 0;
        private  int sodium = 0;
        private  int carbohydrate = 0;

        public Builder(int servomgSize, int servings) {
            this.servomgSize = servomgSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder fat(int val){
            fat = val;
            return this;
        }
        public Builder sodium(int val){
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionFactsWithBuilder build(){
            return new NutritionFactsWithBuilder(this);
        }

    }

    private NutritionFactsWithBuilder(Builder builder){
        servomgSize = builder.servomgSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }


    public static void main(String[] args) {
        NutritionFactsWithBuilder cocaCola = new Builder(240,8).calories(100).sodium(35).carbohydrate(27).build();
    }


}
