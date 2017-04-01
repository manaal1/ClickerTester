package com.coder.clickertester;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 *
 * @author  Rashmika Nugur
 * @StudentID: 100941848
 * @COMP 3074
 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private static Toast toastInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Detect press on buttons/views
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.redView).setOnClickListener(this);
        findViewById(R.id.greenView).setOnClickListener(this);
        findViewById(R.id.yellowView).setOnClickListener(this);
        findViewById(R.id.blueView).setOnClickListener(this);

        // Detect long press on views
        findViewById(R.id.redView).setOnLongClickListener(this);
        findViewById(R.id.greenView).setOnLongClickListener(this);
        findViewById(R.id.yellowView).setOnLongClickListener(this);
        findViewById(R.id.blueView).setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String message = "";
        switch (v.getId()) {
            case R.id.button:
                finish();
                return;
            case R.id.redView:
                message = "Short click: Upper left block (red)";
                break;
            case R.id.greenView:
                message = "Short click: Upper right block (green)";
                break;
            case R.id.yellowView:
                message = "Short click: Bottom left block (yellow)";
                break;
            case R.id.blueView:
                message = "Short click: Bottom right block (blue)";
                break;
        }

        //Show Toast
        if (!message.isEmpty()) {
            showToast(this, message);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        // Depending on the view id, create the correct message
        String message = "";
        switch (v.getId()) {
            case R.id.redView:
                message = "Long click: Upper left block (red)";
                break;
            case R.id.greenView:
                message = "Long click: Upper right block (green)";
                break;
            case R.id.yellowView:
                message = "Long click: Bottom left block (yellow)";
                break;
            case R.id.blueView:
                message = "Long click: Bottom right block (blue)";
                break;
        }

        //Show Toast
        if (!message.isEmpty()) {
            showToast(this, message);
            return true;
        };

        return false;
    }

    /**
     * Method that uses a singleton so that on multiple presses the toast will not show delayed or too many times
     * @param context
     * @param text
     */
    private void showToast(Context context, String text) {
        if (toastInstance == null) {
            toastInstance = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toastInstance.setText(text);
        }

        toastInstance.show();
    }
}
