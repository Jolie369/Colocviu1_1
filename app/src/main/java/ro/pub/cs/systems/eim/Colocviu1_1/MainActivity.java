package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText EditText;
    private Button NorthButton, EastButton, WestButton, SouthButton;
    public int presses;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String text = EditText.getText().toString();

            switch(view.getId()) {
                case R.id.north_button:
                    text = text + "North, ";
                    presses++;
                    EditText.setText(String.valueOf(text));
                    break;
                case R.id.south_button:
                    text = text + "South, ";
                    presses++;
                    EditText.setText(String.valueOf(text));
                    break;
                case R.id.east_button:
                    text = text + "East, ";
                    presses++;
                    EditText.setText(String.valueOf(text));
                    break;
                case R.id.west_button:
                    text = text + "West, ";
                    presses++;
                    EditText.setText(String.valueOf(text));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presses = 0;

        EditText = (EditText)findViewById(R.id.edit_text);

        NorthButton = (Button)findViewById(R.id.north_button);
        SouthButton = (Button)findViewById(R.id.south_button);
        EastButton = (Button)findViewById(R.id.east_button);
        WestButton = (Button)findViewById(R.id.west_button);

        EditText.setText(String.valueOf(""));

        NorthButton.setOnClickListener(buttonClickListener);
        EastButton.setOnClickListener(buttonClickListener);
        WestButton.setOnClickListener(buttonClickListener);
        SouthButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.PRESSES, String.valueOf(presses));
        Log.d(Constants.PRESSES, "NUMBER OF PRESSES");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.PRESSES)) {
            Log.d(Constants.PRESSES, "NUMBER OF PRESSES");
            Toast.makeText(this, "Number of presses: " + Constants.PRESSES, Toast.LENGTH_LONG).show();
        }
    }
}