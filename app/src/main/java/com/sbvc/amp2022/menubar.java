package com.example.menubar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.Settings:
                Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Redirecting to another app",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Search:
                Uri uri = Uri.parse( "https://www.google.co.in" );
                startActivity( new Intent( Intent.ACTION_VIEW, uri ) );
                Toast.makeText(this, "opening Browser", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.SendEmail:
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("plain/text");
                intent1.putExtra(Intent.EXTRA_EMAIL, new String[] {"xyz@gmail.com"});
                startActivity(intent1);
                Toast.makeText(getApplicationContext(),"Redirecting to Mail",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Feedback:
                Toast.makeText(getApplicationContext(),"Send Feedback",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
}


}
