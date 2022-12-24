package com.example.transit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Login extends AppCompatActivity {

    private Button button1 ;
    private Button button2 ;


    private Button buttonlogin ;
    private Button buttonsignup ;

    EditText EmailInput,PasswordInput;
    Button btnlogin;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle bundle=getIntent().getExtras();
        if (bundle != null){
            if (bundle.getString("some")!= null){
                Toast.makeText(getApplicationContext(),"data:"+bundle.getString("some"),Toast.LENGTH_SHORT).show();
            }

        }




        button1=(Button)  findViewById(R.id.sign_up);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitysignup();
            }
        });
        button2=(Button)  findViewById(R.id.log_in);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDashboard();
            }
        });




        EmailInput=findViewById(R.id.login_Email_Input);
        PasswordInput=findViewById(R.id.login_Password_Input);
        btnlogin=(Button)  findViewById(R.id.log_in);

        firebaseAuth=FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EmailInput.getText().toString().isEmpty() && PasswordInput.getText().toString().isEmpty()){

                    validate(EmailInput.getText().toString(),PasswordInput.getText().toString());

                }else {
                    Toast.makeText(Login.this,"Remplir les schémas ",Toast.LENGTH_SHORT).show();
                }

            } });

        buttonlogin=(Button)  findViewById(R.id.log_in);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDashboard();
            }
        });


        buttonsignup=(Button)  findViewById(R.id.sign_up);
        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitysignup();
            }
        });
    }

    private void validate(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()){
                    Toast.makeText(Login.this," Ce mail n'est pas inscrit",Toast.LENGTH_SHORT).show();
                }else{
                    checkifEmailVerified();
                }
            }
        });
    }

    private void checkifEmailVerified() {
        FirebaseUser user =firebaseAuth.getCurrentUser();
        assert user !=null;
        if(user.isEmailVerified()){
            Toast.makeText(Login.this,"Succès",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this,MainActivity.class));
        }else{
            Toast.makeText(Login.this,"vérifier votre email ",Toast.LENGTH_SHORT).show();
        }
    }

    public void openActivityDashboard(){
        Intent intent = new Intent(this,Dashboard.class);
        startActivity(intent);
    }
    public void openActivitysignup(){
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
    }

}
