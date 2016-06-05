package com.christopherluc.androidjokelibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "extra-joke";

    public static Intent getIntent(Context context, String joke) {
        Intent i = new Intent(context, JokeActivity.class);
        i.putExtra(EXTRA_JOKE, joke);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        if (TextUtils.isEmpty(joke)) {
            displayErrorAndFinish();
        }
        else {
            TextView textView = (TextView) findViewById(R.id.joke_text);
            if (textView != null) {
                textView.setText(joke);
            }
        }
    }

    private void displayErrorAndFinish() {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("No Joke Provided")
                .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }
}
