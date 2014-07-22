package com.example.LocalDelicacies;

import java.util.ArrayList;

public class FoodListFragment extends ListFragment {
    @Override
    public void populateModels(ArrayList<BaseModel> items) {
        items.add(new FoodModel("Tacos","rolls",0, "Tacos are delicious."));
        items.add(new FoodModel("Gator Tail","rolls",1, "Gator is delicious."));
        items.add(new FoodModel("Satchel's Pizza","rolls",2, "Pizza is delicious."));
        items.add(new FoodModel("Some other food","rolls",3, "Food in general is delicious."));
        items.add(new FoodModel("Suddenly more food","rolls",4, "Surprises are delicious."));
        items.add(new FoodModel("I love food so much","rolls",5, "Love is delicious"));
    }

}
