package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener
{
    private Button exitButton;
    private EditText nameEntry;
    private String name;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exitButton = (Button)findViewById(R.id.exitButton);
        nameEntry = (EditText)findViewById(R.id.nameEntry);
        nameEntry.setWidth(120);
        exitButton.setOnClickListener(this);
        nameEntry.setFocusable(true);
    }// End of onCreate
    @Override
    public void onClick(View v)
    {
// Check for exit button. Pop up dialogue if found
        if (v == exitButton)
        {
            name = nameEntry.getText().toString();
            showtbDialog(name);
        }
    }// End of onClick

    private void showtbDialog(String salutationName)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(salutationName + ", Are you sure you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(getApplicationContext(), name + " You Pressed " +
                        "Yes", Toast.LENGTH_SHORT).show();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(getApplicationContext(), name + " You Pressed " +
                        "No", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}// End of Activity class