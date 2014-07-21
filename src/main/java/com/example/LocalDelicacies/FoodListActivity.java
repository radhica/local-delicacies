package com.example.LocalDelicacies;

import java.util.ArrayList;

public class FoodListActivity extends ListActivity {
    @Override
    public void populateModels(ArrayList<BaseModel> items) {
        items.add(new FoodModel("Tacos","imageUrl1",1));
        items.add(new FoodModel("Gator Tail","imageUrl2",2));
        items.add(new FoodModel("Satchel's Pizza","imageurl3",3));
        items.add(new FoodModel("Some other food","imageUrl1",4));
        items.add(new FoodModel("Suddenly more food","imageUrl2",5));
        items.add(new FoodModel("I love food so much","imageurl3",6));
        items.add(new FoodModel("Gainesville","imageUrl1",7));
    }

}
