package com.example.peerial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class teacherHome extends AppCompatActivity {

    private ImageButton homeButton, newPostButton, settingsButton;
    public static TextView postOne;
    public static ArrayList<String> posts = new ArrayList<String>();
    public static ArrayList<TextView> textviews = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        posts.add("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        homeButton = findViewById(R.id.home);
        newPostButton = findViewById(R.id.newPost);
        settingsButton = findViewById(R.id.settings);

        if(!PostActivity.msg.isEmpty()){

            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl);

            posts.add(PostActivity.msg);
            for(int i = 0; i < posts.size(); i++) {
                Log.e("post", posts.get(i));

                RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
                textParams.leftMargin = 100;
                textParams.topMargin = i * 100;

                //RelativeLayout.LayoutParams nameParams = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
                //nameParams.leftMargin = 50;
                //nameParams.topMargin = i * 100;

                TextView x = new TextView(this);
                x.setText(posts.get(i));
                x.setTextColor(Color.BLACK);
                x.setTextSize((float) 20);
                x.setLayoutParams(textParams);
                textviews.add(x);
                relativeLayout.addView(x);

                TextView name = new TextView(this);

                String emailStr, username;

                if(SettingsActivity.nameText != null && !(SettingsActivity.nameText.getText() + "").isEmpty()){
                    username = SettingsActivity.nameText.getText() + "";
                } else {
                    if(MainActivity.isLogged) emailStr = MainActivity.email.getText() + "";
                    else emailStr = SignInActivity.email.getText() + "";

                    username = emailStr.substring(0, emailStr.indexOf("@"));
                }

                name.setText(username + ": ");
                name.setTextSize((float) 20);
                name.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                RelativeLayout.LayoutParams nameParams = textParams;
                nameParams.leftMargin = 100;
                nameParams.topMargin = i * 50;
                name.setLayoutParams(nameParams);
                relativeLayout.addView(name);

            }
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nothing
            }
        });

        newPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(PostActivity.class);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SettingsActivity.class);
            }
        });
    }

    public void openActivity(Class<?> cls){
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void setPostText(String str){
        postOne.setText(str);
    }
}