package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;

import com.example.customlistview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] imageList = new int[]{R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6};
        int[] ingredientList ={R.string.pizzaIngredients,R.string.friesIngredients,R.string.maggiIngredients,R.string.pancakeIngredients,R.string.burgerIngredients,R.string.cakeIngredients,R.string.pastaIngredients};
        int[] descList ={R.string.pizzaDesc,R.string.friesDesc, R.string.maggiDesc,R.string.pancakeDesc,R.string.burgerDesc,R.string.cakeDesc,R.string.pastaDeck};
        String[] nameList ={"Pizza","Fries","Maggi","Pancake","Burger", "Cake","Pasta",};
        String[] timeList ={"30 mins", "2 mins", "45 mins","10 mins", "60 mins" , "45 mins", "30 mins"};

        for (int i = 0; i <imageList.length; i++){
            listData = new ListData(nameList[i], timeList[1], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DeatailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}