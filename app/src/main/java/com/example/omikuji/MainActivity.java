package com.example.omikuji;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startBtn = findViewById(R.id.start_button);
        startBtn.setOnClickListener(v -> {
            //スタートボタンタップ処理
            //TODO:おみくじの抽選を実行
            //TODO:結果画面に遷移
            //context：アプリの情報(Application Context Activity Context)
            //クラス
            Random randomGenerator = new Random();
            int number = randomGenerator.nextInt(ResultActivity.MAX_OMIKUJI_COUNT);
            Intent intent = ResultActivity.newIntent(MainActivity.this,number);
            startActivity(intent);

        });

    }
}