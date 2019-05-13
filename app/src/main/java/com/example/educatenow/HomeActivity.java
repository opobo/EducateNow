package com.example.educatenow;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class HomeActivity extends AppCompatActivity {
private HomeFragment homeFragment;
private  PostionFragment postionFragment;
private ProgramFragment programFragment;

private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //ADDING SUPPORT TO ACTION BAR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//instiating the fragments
        frameLayout=findViewById(R.id.frame_layout);
        homeFragment=new HomeFragment();
        postionFragment=new PostionFragment();
        programFragment=new ProgramFragment();

//        setting the default frafgment
        setFragment(homeFragment);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_items_list,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.history:
                setFragment(homeFragment);
                return true;
            case R.id.rank:
                setFragment(postionFragment);
                return true;
            case R.id.faculty:
                setFragment(programFragment);
                return true;
            case R.id.apply:
                startActivity(new Intent(getApplicationContext(),ApplyActivity.class));
                return true;
            case R.id.Share_app_menu:
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("plain/text");
                startActivity(Intent.createChooser(intent,"SHARE APP WITH OTHERS"));
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }
    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
}
