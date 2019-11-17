package com.example.peerial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TsActivity extends AppCompatActivity {

    private Button teacher;
    private Button student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts);

        teacher = findViewById(R.id.teacher);
        student = findViewById(R.id.student);

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeacherHome();
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeacherHome();
            }
        });
    }

    private void openTeacherHome() {
        Intent intent = new Intent(this, teacherHome.class);
        startActivity(intent);
    }

//    private void openStudentHome() {
//        Intent intent = new Intent(this, studentHome.class);
//        startActivity(intent);
//    }
}
