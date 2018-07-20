package chap2;

//telescoping constructor pattern -does not scale well!
public class NutritionFacts {
    private final int servomgSize;  //(mL)  required
    private final int servings;  //(per container)  required
    private final int calories;  //   optional
    private final int fat;  // (g)  optional
    private final int sodium;  //(mg)   optional
    private final int carbohydrate;  //(g)   optional

    public NutritionFacts(int servomgSize, int servings) {
        this(servomgSize,servings,0);
    }

    public NutritionFacts(int servomgSize, int servings, int calories) {
        this(servomgSize,servings,calories,0);
    }

    public NutritionFacts(int servomgSize, int servings, int calories, int fat) {
        this(servomgSize,servings,calories,fat,0);
    }

    public NutritionFacts(int servomgSize, int servings, int calories, int fat, int sodium) {
       this(servomgSize,servings,calories,fat,sodium,0);
    }

    public NutritionFacts(int servomgSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servomgSize = servomgSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
