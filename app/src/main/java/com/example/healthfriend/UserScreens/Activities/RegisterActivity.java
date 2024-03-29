package com.example.healthfriend.UserScreens.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthfriend.UserScreens.User;
import com.example.healthfriend.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    TextView loginText;
EditText email,pass,confirmPass;
ProgressDialog progressDialog;
FirebaseAuth mAuth;
FirebaseUser mUser;
String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";
    AppCompatButton registerBtn;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(this);
        email=findViewById(R.id.reg_email);
        loginText=findViewById(R.id.login_text);
        pass=findViewById(R.id.reg_pass);
        confirmPass=findViewById(R.id.reg_confirmpass);
        registerBtn = findViewById(R.id.reg_btn);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
              //  intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
progressDialog=new ProgressDialog(this);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
                perforAuth();
            }
        });
    }

    private void perforAuth() {
        String EMAIL=email.getText().toString();
        String PASS=pass.getText().toString();
        String CONPASS=confirmPass.getText().toString();
        if(!EMAIL.matches(emailPattern)){
            email.setError("Please enter a valid email");
        } else if (PASS.isEmpty()||PASS.length()<6) {
           pass.setError("Please enter a proper password");
        } else if (!PASS.equals(CONPASS)) {
            confirmPass.setError("passwords don't match");
        }else {
            progressDialog.setMessage("please wait for registration");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(EMAIL,PASS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isComplete()){
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,"Registration Done",Toast.LENGTH_LONG).show();
                        sendUserToAnthorActivity();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,"Registration failed",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void sendUserToAnthorActivity() {
        User newUser = User.getInstance();
        newUser.setEmail(email.getText().toString());
//        QuestionnaireFragment questionnaireFragment = new QuestionnaireFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.register_frame, questionnaireFragment).addToBackStack(null).commit();

        Intent intent=new Intent(RegisterActivity.this, QuestionnaireAct.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}