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
import java.util.Random;

public class AdvancedLevel extends AppCompatActivity {

    private ArrayList<String> carBrandList = new ArrayList<>();
    private ArrayList<Integer> carImages = new ArrayList<>();

    ImageView imgAL1;
    ImageView imgAL2;
    ImageView imgAL3;
    EditText answer1;
    EditText answer2;
    EditText answer3;
    Button btnNext;
    TextView txtAnswer1;
    TextView txtAnswer2;
    TextView txtAnswer3;
    TextView txtAnswerAll;

    String x = null;
    String y = null;
    String z = null;

    boolean b1 = false;
    boolean b2 = false;
    boolean b3 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        imgAL1 = findViewById(R.id.imgAl1);
        imgAL2 = findViewById(R.id.imgAl2);
        imgAL3 = findViewById(R.id.imgAl3);
        answer1= findViewById(R.id.answer1);
        answer2= findViewById(R.id.answer2);
        answer3= findViewById(R.id.answer3);
        btnNext = findViewById(R.id.btnNext);
        txtAnswer1 = findViewById(R.id.txtAnswer1);
        txtAnswer2 = findViewById(R.id.txtAnswer2);
        txtAnswer3 = findViewById(R.id.txtAnswer3);
        txtAnswerAll = findViewById(R.id.txtAnswerAll);

        addCarBrands();
        addCarImages();
        addRandomImage();
        btnNext.setText("SUBMIT");
    }


    public void addRandomImage() {

        Random random = new Random();

        while (true) {

            int randomImage1 = random.nextInt(carImages.size()-1);//random image

            int randomImage2 = random.nextInt(carImages.size()-1);//random image

            int randomImage3 = random.nextInt(carImages.size()-1);//random image

            if (randomImage1 == randomImage2 || randomImage1 == randomImage3 || randomImage2 == randomImage3) {
                continue;
            } else {

                /**image1*/
                imgAL1.setImageResource(carImages.get(randomImage1));

                //set tag for image
                imgAL1.setTag(carImages.get(randomImage1));

                //remove image from list after showing once
                carImages.remove(randomImage1);

                /**image2*/
                imgAL2.setImageResource(carImages.get(randomImage2));

                //set tag for image
                imgAL2.setTag(carImages.get(randomImage2));

                //remove image from list after showing once
                carImages.remove(randomImage2);

                /**image3*/

                imgAL3.setImageResource(carImages.get(randomImage3));

                //set tag for image
                imgAL3.setTag(carImages.get(randomImage3));

                //remove image from list after showing once
                carImages.remove(randomImage3);

                //get tag from image and assign to string
                String image1Tag = getResources().getResourceName((Integer) imgAL1.getTag());
                String image2Tag = getResources().getResourceName((Integer) imgAL2.getTag());
                String image3Tag = getResources().getResourceName((Integer) imgAL3.getTag());

                String x = null;
                String y = null;
                String z = null;

                //get image 1
                for (int i = 0; i < carBrandList.size(); i++) {
                    if (image1Tag.contains(carBrandList.get(i))) {    //compare with tag name
                        x = carBrandList.get(i);
                    }
                }

                //get image 2
                for (int i = 0; i < carBrandList.size(); i++) {
                    if (image2Tag.contains(carBrandList.get(i))) {    //compare with tag name
                        y = carBrandList.get(i);
                    }
                }

                //get image 3
                for (int i = 0; i < carBrandList.size(); i++) {
                    if (image3Tag.contains(carBrandList.get(i))) {    //compare with tag name
                        z = carBrandList.get(i);
                    }
                }
                if (x.equals(y) || x.equals(z) || y.equals(z)) {
                    continue;
                } else {
                    //remove that random image after showing once
                    carImages.remove(randomImage1);
                    carImages.remove(randomImage2);
                    carImages.remove(randomImage3);

                    break;
                }
            }
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

        //get Tag from images


        if (btnNext.getText().toString().equals("SUBMIT")) {

            String string1 = getResources().getResourceName((Integer) imgAL1.getTag());
            String string2 = getResources().getResourceName((Integer) imgAL2.getTag());
            String string3 = getResources().getResourceName((Integer) imgAL3.getTag());

            // lowercase al letters in input text
            String input1 = answer1.getText().toString().toLowerCase();
            String input2 = answer2.getText().toString().toLowerCase();
            String input3 = answer3.getText().toString().toLowerCase();

        //compare with 1st image tag
            if (string1.contains(input1)) {
                answer1.setTextColor(Color.GREEN);
                answer1.setEnabled(false);
                b1 = true;
            } else {
                txtAnswer1.setText(string1);
                txtAnswer1.setTextColor(Color.YELLOW);
                answer1.setTextColor(Color.RED);
            }
        //compare with 2nd image tag
            if (string2.contains(input2)) {
                answer2.setTextColor(Color.GREEN);
                answer2.setEnabled(false);
                b2 = true;
            } else {
                txtAnswer2.setText(string2);
                txtAnswer2.setTextColor(Color.YELLOW);
                answer2.setTextColor(Color.RED);
            }
        //compare with 3rd image tag
            if (string3.contains(input3)) {
                answer3.setTextColor(Color.GREEN);
                answer3.setEnabled(false);
                b3 = true;
            } else {
                txtAnswer3.setText(string3);
                txtAnswer3.setTextColor(Color.YELLOW);
                answer3.setTextColor(Color.RED);
            }

            //answer from all answers box(all correct)
            if (b1 == true && b2 == true && b3 == true) {
                txtAnswerAll.setText("C o r r e c t ✔");
                txtAnswerAll.setTextColor(Color.GREEN);
            } else {
                txtAnswerAll.setText("W r o n g ❌");
                txtAnswerAll.setTextColor(Color.RED);
            }

            btnNext.setText("NEXT");
        } else {
            btnNext.setText("SUBMIT");
            answer1.setText("");
            answer2.setText("");
            answer3.setText("");

            answer1.setTextColor(Color.BLACK);
            answer2.setTextColor(Color.BLACK);
            answer3.setTextColor(Color.BLACK);

            //disable text input
            answer1.setEnabled(true);
            answer2.setEnabled(true);
            answer3.setEnabled(true);

            txtAnswerAll.setText("");
            txtAnswer1.setText("");
            txtAnswer2.setText("");
            txtAnswer3.setText("");
            addCarBrands();
            addCarImages();
            addRandomImage();
        }
    }
}