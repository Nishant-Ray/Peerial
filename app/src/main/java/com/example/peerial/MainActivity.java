package com.example.peerial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth f;
    private Button signUp;
    private Button login;
    public static EditText email;
    private EditText pwd;

    public static boolean isLogged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f = FirebaseAuth.getInstance();

        signUp = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        pwd = findViewById(R.id.pass);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ts(SignInActivity.class);
            }
        });


        setLogin();
    }



    private void setLogin() {
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!email.getText().toString().equals("") && !pwd.getText().toString().equals("")) {
                    f.signInWithEmailAndPassword(email.getText().toString(), pwd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.e("lslfjlsjfllsffs", "success");
                            if (task.isSuccessful()) {
                                isLogged = true;
                                ts(TsActivity.class);
                            } else {
                                Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
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
