package com.example.omikuji;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    //おみくじの数
    public static final int MAX_OMIKUJI_COUNT = 7;

    private static final int ERROR_CODE = -1;

    private static final String KEY_OMIKUJI_NUMBER = "key_omikuji_number";
    //
    public static Intent newIntent(Context context,int number){
       Intent intent= new Intent(context,ResultActivity.class);
       intent.putExtra(KEY_OMIKUJI_NUMBER,number);
       return intent;
    }

    private ImageView omikujiImageView;
    private ImageView womanImageView;
    private ImageView manImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Image
        omikujiImageView = findViewById(R.id.result_img);
        womanImageView = findViewById(R.id.woman_img);
        manImageView = findViewById(R.id.man_img);
        //値の取得
        int number = getIntent().getIntExtra(KEY_OMIKUJI_NUMBER,ERROR_CODE);
        //画像のリソースID
        int imageResId = -1;
        boolean isHuman = false;
        switch (number){
            case 0: //大吉
                isHuman = true;
                imageResId = R.drawable.omikuji_daikichi;
                break;
            case 1://中吉
                isHuman = true;
                imageResId = R.drawable.omikuji_chuukichi;
                break;
            case 2://小吉
                isHuman = true;
                imageResId = R.drawable.omikuji_syoukichi;
                break;
            case 3://吉
                isHuman = true;
                imageResId = R.drawable.omikuji_kichi;
                break;
            case 4://末吉
                isHuman = false;
                imageResId = R.drawable.omikuji_suekichi;
                break;
            case 5://凶
                isHuman = false;
                imageResId = R.drawable.omikuji_kyou;
                break;
            case 6://大凶
                isHuman = false;
                imageResId = R.drawable.omikuji_daikyou;
                break;
            default://エラー
                throw new RuntimeException("error: number is not found.");
        }
        omikujiImageView.setImageResource(imageResId);
        switchdisplayHuman(isHuman);
    }
    //いなくなったりいたりするところ
    private void switchdisplayHuman(boolean isVisible){
        int visibility = isVisible ? View.VISIBLE : View.INVISIBLE;
        womanImageView.setVisibility(visibility);
        manImageView.setVisibility(visibility);
    }
}