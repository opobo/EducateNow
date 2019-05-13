package com.example.educatenow;
//STUDENT NAME : OPOBO PHILLIMON
//STUDENT REG NO: 2017/BIT/
import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
public Button userLoginButton;
public EditText userNameArea;
DatabaseTester tester;
public EditText userPasswordArea;
BroadCastGetter broadCastGetter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instatiang the BUTTON
        userLoginButton=findViewById(R.id.btnLogin);
        userNameArea=(EditText)findViewById(R.id.username);
        userPasswordArea=(EditText)findViewById(R.id.userPassword);
        tester=new DatabaseTester(this);

broadCastGetter=new BroadCastGetter();
        //SETTING THE ON CLICK LISTENER ON THE BUTTON LOGIN
        userLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginMethod(userNameArea.getText().toString(),userPasswordArea.getText().toString());
            }
        });
    }
    private void userLoginMethod(String name,String password) {
        if (TextUtils.isEmpty(name)|| TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Cannot read empty fields, Check entries",Toast.LENGTH_LONG).show();
            userNameArea.requestFocus();
        }

       else{
           boolean getData=tester.signInUserWithUserNameAndPassword(name,password);

           if (getData==true){
            Intent intent=new Intent(MainActivity.this,LevelActivity.class);
            startActivity(intent);
            MainActivity.this.finish();
           }
           else{
               Toast.makeText(getApplicationContext(),"Username and Password doesn't match",Toast.LENGTH_LONG).show();
           }

        }

    }

    public void createUserAccount(View view) {
        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadCastGetter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadCastGetter,intentFilter);
    }
}
