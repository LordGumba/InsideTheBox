// MainActivity.java
package com.example.ballgame;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

//Sets up layout for the GameView
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}