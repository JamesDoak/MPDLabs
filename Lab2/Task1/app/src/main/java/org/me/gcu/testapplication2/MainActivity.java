package org.me.gcu.testapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener
{

    private View mainView;

    private Button exitButton;
    private TextView salutation;

    /**called when the activity is first created*/
    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView = (View)findViewById(R.id.mainView);
        mainView.setBackgroundColor(getResources().getColor(R.color.green,null));


        exitButton = (Button)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        //check for the exit button, and pop a dialogue if required
        if(v==(Button)findViewById(R.id.exitButton)){
            showtbDialog();
        }
    }

    private void showtbDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(getApplicationContext(), "You pressed Yes", Toast.LENGTH_SHORT).show();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(getApplicationContext(), "You pressed No", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

}