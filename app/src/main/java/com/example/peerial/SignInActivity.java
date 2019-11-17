package com.example.peerial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth f;
    private Button signUp;
    public static EditText email;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        f = FirebaseAuth.getInstance();

        signUp = findViewById(R.id.login);
        email = findViewById(R.id.email);
        pwd = findViewById(R.id.pass);

        setSignUp();

    }

    private void setSignUp() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("") && !pwd.getText().toString().equals("")) {
                    f.createUserWithEmailAndPassword(email.getText().toString(), pwd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                ts(TsActivity.class);
                            } else {
                                Toast.makeText(SignInActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void ts(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
