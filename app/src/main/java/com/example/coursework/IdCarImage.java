package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class IdCarImage extends AppCompatActivity {

    private ArrayList<String> carBrandList = new ArrayList<>();
    private ArrayList<Integer> carImages = new ArrayList<>();

    ImageView imgCarImage1;
    ImageView imgCarImage2;
    ImageView imgCarImage3;
    TextView txtAnswer;
    TextView txtCarBrand;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_car_image);

        imgCarImage1 = findViewById(R.id.imgCarImage1);
        imgCarImage2 = findViewById(R.id.imgCarImage2);
        imgCarImage3 = findViewById(R.id.imgCarImage3);
        btnNext = findViewById(R.id.btnNext);
        txtAnswer = findViewById(R.id.txtAnswer);
        txtCarBrand = findViewById(R.id.txtCarBrand);

        addCarBrands();
        addCarImages();
        addRandomImage();

//        btnNext.setText("IDENTIFY");

    }


    public void addRandomImage() {

        Random random = new Random();

        while (true) {

            int randomImage1 = random.nextInt(carImages.size() - 1);//random image

            int randomImage2 = random.nextInt(carImages.size() - 1);//random image

            int randomImage3 = random.nextInt(carImages.size() - 1);//random image

            if (randomImage1 == randomImage2 || randomImage1 == randomImage3 || randomImage2 == randomImage3) {
                continue;
            } else {

                /**image1*/
                imgCarImage1.setImageResource(carImages.get(randomImage1));

                //set tag for image
                imgCarImage1.setTag(carImages.get(randomImage1));

                //remove image from list after showing once
                carImages.remove(randomImage1);

                /**image2*/
                imgCarImage2.setImageResource(carImages.get(randomImage2));

                //set tag for image
                imgCarImage2.setTag(carImages.get(randomImage2));

                //remove image from list after showing once
                carImages.remove(randomImage2);

                /**image3*/

                imgCarImage3.setImageResource(carImages.get(randomImage3));

                //set tag for image
                imgCarImage3.setTag(carImages.get(randomImage3));

                //remove image from list after showing once
                carImages.remove(randomImage3);

                //get tag from image and assign to string
                String image1Tag = getResources().getResourceName((Integer) imgCarImage1.getTag());
                String image2Tag = getResources().getResourceName((Integer) imgCarImage2.getTag());
                String image3Tag = getResources().getResourceName((Integer) imgCarImage3.getTag());

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
                if (x.equals(y) || x.equals(z) || y.equals(z))
                    continue;
                else {
                    //remove that random image after showing once
                    carImages.remove(randomImage1);
                    carImages.remove(randomImage2);
                    carImages.remove(randomImage3);

                    /**random car brand*/
                    txtCarBrand.setText(y);
                    break;
                }
            }
        }

    }

    public void submit(View view) {
        txtAnswer.setText("");
        addCarImages();
        addCarBrands();
        addRandomImage();
    }

    /**
     * Clickable image
     */
    public void onClickImage(View view) {
        String s = getResources().getResourceName((Integer) view.getTag());

        if (s.contains(txtCarBrand.getText().toString())) {
            txtAnswer.setText("C o r r e c t ✔");
            txtAnswer.setTextColor(Color.GREEN);
        } else {
            txtAnswer.setText("W r o n g ❌");
            txtAnswer.setTextColor(Color.RED);
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

    public void addCarImages() {

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
}