package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button LoginPage_Btn_signIn;
    private Button LoginPage_Btn_Register;
    private EditText LoginPage_ET_Name;
    private EditText LoginPage_ET_Email;
    private EditText LoginPage_ET_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance ();

        LoginPage_Btn_Register = findViewById (R.id.loginpage_BTN_Register);
        LoginPage_Btn_signIn = findViewById (R.id.loginpage_BTN_SignIn);
        LoginPage_ET_Email = findViewById (R.id.loginpage_PT_Email);
        LoginPage_ET_Name = findViewById (R.id.loginpage_PT_Name);
        LoginPage_ET_Password = findViewById (R.id.loginpage_PT_Password);


        if(mAuth.getCurrentUser () != null){
            //User Not logged in
            finish ();
            startActivity (new Intent (getApplicationContext (),menuActivity.class));
        }

        LoginPage_Btn_signIn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {



            }
        });

        LoginPage_Btn_Register.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                    String getMail = LoginPage_ET_Email.getText ().toString ().trim ();
                    String getPassword = LoginPage_ET_Password.getText ().toString ().trim ();
                    createAccount (getMail, getPassword);

                    Intent intent = new Intent (loginActivity.this, menuActivity.class);
                    startActivity (intent);
                }

        });
    }


    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Testing", "Sign Up is Successfull" + task.isSuccessful ());
                            if(!task.isSuccessful ()){
                                Toast.makeText (loginActivity.this,"Sorry Failed",Toast.LENGTH_SHORT).show ();
                            }
                        }


                    }
                });
    }

}
