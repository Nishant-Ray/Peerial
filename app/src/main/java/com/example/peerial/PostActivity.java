package com.example.peerial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    public static String msg = "";
    private EditText postText;
    private Button pbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        postText = findViewById(R.id.post);
        pbutton = findViewById(R.id.postbutton);



        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(postText.getText() + "").isEmpty()) {

                    String username, emailStr;

                    if(SettingsActivity.nameText != null && !(SettingsActivity.nameText.getText() + "").isEmpty()){
                        username = SettingsActivity.nameText.getText() + "";
                    } else {
                        if(MainActivity.isLogged) emailStr = MainActivity.email.getText() + "";
                        else emailStr = SignInActivity.email.getText() + "";

                        username = emailStr.substring(0, emailStr.indexOf("@"));
                    }

                    String userLen = "";

                    for(int i = 0; i < username.length()*2; i++){
                        userLen += " ";
                    }

                    msg = userLen + " " + postText.getText();

                    if(!isSwear(msg)) openHome();
                    else Toast.makeText(PostActivity.this, "No Inappropriate Comments", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openHome() {
        Intent intent = new Intent(this, teacherHome.class);
        startActivity(intent);
    }

    private boolean isSwear(String str){

        str = str.toLowerCase();
        str = str.replaceAll("\\s","");

        String[] arr = {"ass", "stupid", "hell", "hate", "bitch", "fuck", "damn", "fag", "arse",
                        "weed", "cocaine", "meth", "marijuana", "heroin", "drugs"};

        for(String x : arr){
            for(int i = 0; i < str.length(); i++){
                if(str.indexOf(x) >= 0) return true;
            }
        }
        return false;
    }
}