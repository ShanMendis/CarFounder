package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HintActivity extends AppCompatActivity {

    private ArrayList<String> carBrandList = new ArrayList<>();
    private ArrayList<Integer> carImages = new ArrayList<>();

    ImageView imgCarHint;
    Button btnNext;
    TextView txtSuggest;
    TextView txtAnswer;
    TextView txtCarHint;
    EditText inputLetter;

    String string = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);


        imgCarHint = findViewById(R.id.imgCarHint);
        btnNext = findViewById(R.id.btnNext);
        txtCarHint = findViewById(R.id.txtCarHint);
        txtAnswer = findViewById(R.id.txtAnswer);
        txtSuggest = findViewById(R.id.txtSuggest);
        inputLetter = findViewById(R.id.inputLetter);

        addCarBrands();
        addCarImages();
        addRandomImage();

    }

    public void addRandomImage() {

        Random random = new Random();
        int randomImage = random.nextInt(carImages.size() - 1);//random image
        imgCarHint.setImageResource(carImages.get(randomImage));

        //set tag for image
        imgCarHint.setTag(carImages.get(randomImage));

        //remove image from list after showing once
        carImages.remove(randomImage);

        String imageTag = getResources().getResourceName((Integer) imgCarHint.getTag());

        for (String x : carBrandList) {
            if (imageTag.contains(x)) {
                string = x;
            }
        }

        txtSuggest.setText("");
        for (int k = 0; k < string.length(); k++) {
            txtSuggest.append("_ ");
        }
    }

    public void submit(View view) {

        if (btnNext.getText().toString().equals("SUBMIT")) {
            String letter = inputLetter.getText().toString().toLowerCase();
            String x = txtSuggest.getText().toString().replace(" ", "");


            String[] a1 = new String[string.length()];
            String[] a2 = new String[string.length()];

            for (int i = 0; i < string.length(); i++) {
                a1[i] = String.valueOf(x.charAt(i));
                a2[i] = String.valueOf(string.charAt(i));
            }

            for (int i = 0; i < string.length(); i++) {
                if (letter.equals(a2[i])) {
                    a1[i] = letter;
                }
            }

            txtSuggest.setText("");
            for (int k = 0; k < string.length(); k++) {
                txtSuggest.append(a1[k] + " ");
            }

            if (Arrays.equals(a1, a2)) {
                txtAnswer.setText("C o r r e c t ✔");
                txtAnswer.setTextColor(Color.GREEN);
                btnNext.setText("NEXT");
            }

        } else {
            txtAnswer.setText("");
            btnNext.setText("SUBMIT");
            addCarBrands();
            addCarImages();
            addRandomImage();
        }

    }


    public void addCarBrands() {
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

    public void addCarImages(){

        carImages.add(R.drawable.ford1);
        carImages.add(R.drawable.ford2);
        carImages.add(R.drawable.ford3);
        carImages.add(R.drawable.porsche1);
        carImages.add(R.drawable.porsche2);
        carImages.add(R.drawable.porsche3);
        carImages.add(R.drawable.ferrari1);
        carImages.add(R.drawable.ferrari2);
        carImages.add(R.drawable.ferrari3);
        carImages.add(R.drawable.subaru1);
        carImages.add(R.drawable.subaru2);
        carImages.add(R.drawable.subaru3);
        carImages.add(R.drawable.toyota1);
        carImages.add(R.drawable.toyota2);
        carImages.add(R.drawable.toyota3);
        carImages.add(R.drawable.nissan1);
        carImages.add(R.drawable.nissan2);
        carImages.add(R.drawable.nissan3);
        carImages.add(R.drawable.honda1);
        carImages.add(R.drawable.honda2);
        carImages.add(R.drawable.honda3);
        carImages.add(R.drawable.mitsubishi1);
        carImages.add(R.drawable.mitsubishi2);
        carImages.add(R.drawable.mitsubishi3);
        carImages.add(R.drawable.mazda1);
        carImages.add(R.drawable.mazda2);
        carImages.add(R.drawable.mazda3);
        carImages.add(R.drawable.bmw1);
        carImages.add(R.drawable.bmw2);
        carImages.add(R.drawable.bmw3);
    }

}