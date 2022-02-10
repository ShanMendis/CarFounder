package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdCarMake extends AppCompatActivity {

    private ArrayList<String> carBrandList = new ArrayList<>();
    private ArrayList<Integer> carImages = new ArrayList<>();

    TextView txtCarMake;
    TextView txtAnswer;
    TextView txtCorrectAnswer;
    Button btnNext;
    Spinner spinner;
    ImageView imgCarMake;
    String carName;
    String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_car_make);

        txtCarMake = findViewById(R.id.txtCarMake);
        txtAnswer = findViewById(R.id.txtAnswer);
        txtCorrectAnswer = findViewById(R.id.txtcorrectAnswer);
        btnNext = findViewById(R.id.btnNext);
        spinner = findViewById(R.id.spinner);
        imgCarMake = findViewById(R.id.imgCarMake);

        addCarBrands();
        addCarImages();
        addRandomImage();

        btnNext.setText("IDENTIFY");

    }


    public void addRandomImage() {
        Random random = new Random();
        int randomImage = random.nextInt(carImages.size() - 1);//random image
        imgCarMake.setImageResource(carImages.get(randomImage));


        //set tag for image
        imgCarMake.setTag(carImages.get(randomImage));
        test = String.valueOf(carImages.get(randomImage));

        //remove image from list after showing once
        carImages.remove(randomImage);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carBrandList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    public void addCarBrands() {
        //add name for array list
        this.carBrandList.add("toyota");
        this.carBrandList.add("nissan");
        this.carBrandList.add("mitsubishi");
        this.carBrandList.add("mazda");
        this.carBrandList.add("subaru");
        this.carBrandList.add("ferrari");
        this.carBrandList.add("ford");
        this.carBrandList.add("honda");
        this.carBrandList.add("porsche");
        this.carBrandList.add("bmw");
    }

    public void addCarImages() {
        //add images for array list
        carImages.add(R.drawable.porsche1);
        carImages.add(R.drawable.porsche2);
        carImages.add(R.drawable.porsche3);
        carImages.add(R.drawable.ford1);
        carImages.add(R.drawable.ford2);
        carImages.add(R.drawable.ford3);
        carImages.add(R.drawable.mitsubishi3);
        carImages.add(R.drawable.mitsubishi2);
        carImages.add(R.drawable.mitsubishi3);
        carImages.add(R.drawable.toyota1);
        carImages.add(R.drawable.toyota2);
        carImages.add(R.drawable.toyota3);
        carImages.add(R.drawable.nissan1);
        carImages.add(R.drawable.nissan2);
        carImages.add(R.drawable.nissan3);
        carImages.add(R.drawable.honda1);
        carImages.add(R.drawable.honda2);
        carImages.add(R.drawable.honda3);
        carImages.add(R.drawable.mazda1);
        carImages.add(R.drawable.mazda2);
        carImages.add(R.drawable.mazda3);
        carImages.add(R.drawable.bmw1);
        carImages.add(R.drawable.bmw2);
        carImages.add(R.drawable.bmw3);
        carImages.add(R.drawable.subaru1);
        carImages.add(R.drawable.subaru2);
        carImages.add(R.drawable.subaru3);
        carImages.add(R.drawable.ferrari1);
        carImages.add(R.drawable.ferrari2);
        carImages.add(R.drawable.ferrari3);

    }

    public void submit(View view) {
        if (btnNext.getText().equals("IDENTIFY")) {

            //get selected name from spinner and assign to string
            String spinnerText = spinner.getSelectedItem().toString();

            //get tag from image and assign to string
            String imageTag = getResources().getResourceName((Integer) imgCarMake.getTag());

            System.out.println(imageTag);

            //looking for same name and same image(selected)
            if (imageTag.contains(spinnerText)) {
                txtAnswer.setTextColor(Color.GREEN);
                txtAnswer.setText("C o r r e c t ✔");

            } else {
                txtAnswer.setTextColor(Color.RED);
                txtAnswer.setText("W r o n g ❌");

                String imgtag = imageTag.substring(imageTag.lastIndexOf("/") + 1);
                String imgtag1 = imgtag.substring(0, imgtag.length() - 1);
                txtCorrectAnswer.setText("It's a " + imgtag1);
                //after identifying button rename as next
                btnNext.setText("NEXT");
                txtCorrectAnswer.setTextColor(Color.BLACK);
            }
        } else {
            // again Identify
            btnNext.setText("IDENTIFY");
            txtAnswer.setText("");
            txtCorrectAnswer.setText("");
            txtAnswer.setTextColor(Color.BLACK);
            txtCorrectAnswer.setTextColor(Color.BLACK);
            addCarImages();
            addCarBrands();
            addRandomImage();
        }
    }
}