package com.vigyat.fitnessappprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    Button resetBtn;
    TextInputEditText UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        resetBtn = findViewById(R.id.resetBtn);
        UserEmail = findViewById(R.id.textInputEditText2);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            @Override
            public void onClick(View view) {



                String emailAddress = UserEmail.getText().toString();

                if(TextUtils.isEmpty(emailAddress)){

                    Toast.makeText(ResetPassword.this, "Email cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ResetPassword.this, "Email sent", Toast.LENGTH_SHORT).show();
                                } else {

                                    Toast.makeText(ResetPassword.this, "Email not sent. Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}