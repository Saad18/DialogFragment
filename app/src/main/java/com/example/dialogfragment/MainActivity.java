package com.example.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.OnInputListener {


    private TextView mInputDisplay;
    public String mInput;

    @Override
    public void sendInput(String input) {

           mInput = input;
           setInputTOTextView();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputDisplay = findViewById(R.id.input_display);
        Button mOpenDialog = findViewById(R.id.open_dialog);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment dialog = new MyDialogFragment();
                dialog.show(getSupportFragmentManager(),"MyDialogFragment");

            }
        });
    }
    private void setInputTOTextView(){
        mInputDisplay.setText(mInput);
    }

}
