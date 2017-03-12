package com.firstandroid.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize action button and set onclick listener
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is a test onclick listener", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Create an onclick listener for the signin button
        final TextView outputFromUsernamePW = (TextView) findViewById(R.id.outputUserpw);
        final EditText stringUsername = (EditText) findViewById(R.id.usernameTextfield);
        final EditText stringPassword = (EditText) findViewById(R.id.passwordTextField);
        Button signInButton = (Button) findViewById(R.id.signIn);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputFromUsernamePW.setText("Hi " + stringUsername.getText()+ ". Your password is: \n"
                        + stringPassword.getText());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.action_settings:
                displaySnackbarMenuItem("Settings");
                return true;
            case R.id.action_Home:
                displaySnackbarMenuItem("Home");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//end switch

    }

    public void displaySnackbarMenuItem(String str){
        Snackbar.make(getWindow().getDecorView(), "You pressed "+ str, Snackbar.LENGTH_LONG).show();
    }

}
