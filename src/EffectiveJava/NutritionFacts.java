package EffectiveJava;

/**
 * Created by rarshion on 16/11/7.
 */
public class NutritionFacts {
    private final int serviceSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private final int serviceSize;
        private final int servings;

        private int calories     = 0;
        private int fat          = 0;
        private int carbohydrate = 0;
        private int sodium       = 0;

        public Builder(int serviceSize, int servings) {
            this.servings = servings;
            this.serviceSize = serviceSize;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        serviceSize = builder.serviceSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8).calories(2).carbohydrate(29).build();
        System.out.println(nutritionFacts.toString());
    }

}
