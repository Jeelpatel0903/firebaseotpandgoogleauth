package com.ajdev.firebaseworkshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class otpenter extends AppCompatActivity {

    EditText intputnumber1, intputnumber2, intputnumber3, intputnumber4, intputnumber5, intputnumber6;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    ProgressBar progressBar;
    String otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpenter);
        intputnumber1 = findViewById(R.id.inputotp1);
        intputnumber2 = findViewById(R.id.inputotp2);
        intputnumber3 = findViewById(R.id.inputotp3);
        intputnumber4 = findViewById(R.id.inputotp4);
        intputnumber5 = findViewById(R.id.inputotp5);
        intputnumber6 = findViewById(R.id.inputotp6);

        TextView textView = findViewById(R.id.textmobilenumber);

        String mobileNo = "+91" + getIntent().getStringExtra("mobile");
        textView.setText(String.format("+91-%s", getIntent().getStringExtra("mobile")));
        Button verfiybuttonclick = findViewById(R.id.submit);
        otp = getIntent().getStringExtra("otp");
         Toast.makeText(this, otp, Toast.LENGTH_SHORT).show();
        final ProgressBar progressBar = findViewById(R.id.processbar_verify_otp);


        verfiybuttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!intputnumber1.getText().toString().trim().isEmpty() && !intputnumber2.getText().toString().trim().isEmpty() && !intputnumber3.getText().toString().trim().isEmpty() && !intputnumber4.getText().toString().trim().isEmpty() && !intputnumber5.getText().toString().trim().isEmpty() && !intputnumber6.getText().toString().trim().isEmpty()) {
                    String entercode = intputnumber1.getText().toString() + intputnumber2.getText().toString() + intputnumber3.getText().toString() + intputnumber4.getText().toString() + intputnumber5.getText().toString() + intputnumber6.getText().toString();
                    if (otp != null) {
                        progressBar.setVisibility(View.VISIBLE);
                        verfiybuttonclick.setVisibility(View.INVISIBLE);
                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                                otp, entercode
                        );
                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.INVISIBLE);
                                verfiybuttonclick.setVisibility(View.VISIBLE);
                                if (task.isSuccessful()) {
                                    Intent intent1 = new Intent(getApplicationContext(), HomeScreen.class);
                                   // Intent intent1 = Intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivities(new Intent[]{intent1});
                                } else {
                                    Toast.makeText(otpenter.this, "Please enter correct OTP", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(otpenter.this, "please check your Internet Connectivity", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(otpenter.this, "please enter all numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });


        numberoptmove();
    }

    private void numberoptmove() {
        intputnumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    intputnumber2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        intputnumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    intputnumber3.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        intputnumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    intputnumber4.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        intputnumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    intputnumber5.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        intputnumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    intputnumber6.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}