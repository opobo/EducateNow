package com.example.educatenow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
EditText fullname,username,password,confirm;
DatabaseTester tester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname=findViewById(R.id.fullname);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirm=findViewById(R.id.confirm);
        tester=new DatabaseTester(this);


    }

    public void createAccount(View view) {
        saveUserInformationInDatabase();
    }

    private void saveUserInformationInDatabase() {
        String full=fullname.getText().toString().trim();
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        String con=confirm.getText().toString().trim();

//        Validating the user information before save in the database
        if (TextUtils.isEmpty(full) ||TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)||TextUtils.isEmpty(con)){
            Toast.makeText(getApplicationContext(),"Account form cannot take empty fields",Toast.LENGTH_LONG).show();
        }
        else if (pass.length()<6){
            Toast.makeText(getApplicationContext(),"Password must contain at least 6 character",Toast.LENGTH_LONG).show();
        }
        else if (!pass.equals(con)){
            Toast.makeText(getApplicationContext(),"Password doesn't match the confirmation",Toast.LENGTH_LONG).show();
        }
        else {
//            Inserting data into the database
            boolean callTester = tester.addUserData(full, user, pass);
            if (callTester == true) {
                Toast.makeText(getApplicationContext(),"Congratulations ! user has been recorde successfully",Toast.LENGTH_LONG).show();
                fullname.setText("");
                username.setText("");
                password.setText("");
                confirm.setText("");
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            } else {
                Toast.makeText(getApplicationContext(), "Something went wrong user not added \n Please try again latter", Toast.LENGTH_SHORT).show();
            }
        }}

}
