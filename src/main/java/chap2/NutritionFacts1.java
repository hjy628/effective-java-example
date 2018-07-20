package chap2;

//JavaBeans Pattern - allows inconsistency,mandates mutability
public class NutritionFacts1 {
    //Parameters initialized to default values (if any)
    private  int servomgSize = -1;  //(mL)  required no default value
    private  int servings = -1 ;  //(per container)
    private  int calories = 0;  //   optional
    private  int fat = 0;  // (g)  optional
    private  int sodium = 0 ;  //(mg)   optional
    private  int carbohydrate = 0;  //(g)   optional

    public NutritionFacts1() {
    }

    //Setters
    public void setServomgSize(int servomgSize) {
        this.servomgSize = servomgSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
