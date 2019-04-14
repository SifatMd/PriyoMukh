package com.antu.bazinga.priyomukh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTabButtonClick(View view){
        Intent intent = new Intent(this, TabMotherChild.class);
        startActivity(intent);
    }

    public void onBotButtonClicked(View view){
        //intent to bot activity
        Intent intent = this.getPackageManager().getLaunchIntentForPackage("com.example.vmac.chatbot");
        this.startActivity(intent);

    }
}
