package ro.pub.cs.systems.practicaltest01var06;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {
    EditText name,url;
    String aux1,aux2;
    Button ok,cancel;
    ButtonDetailsListener buttonDetailsListener = new ButtonDetailsListener();
    private class ButtonDetailsListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.OK_button){
                Intent intentToParent = new Intent();
                setResult(RESULT_OK, intentToParent);
                finish();
            }else{
                Intent intentToParent = new Intent();
                setResult(RESULT_CANCELED, intentToParent);
                finish();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        name = (EditText)findViewById(R.id.StudentNameSecond);
        url = (EditText)findViewById(R.id.URLSecond);

        cancel = (Button)findViewById(R.id.Cancel_button);
        cancel.setOnClickListener(buttonDetailsListener);
        ok = (Button)findViewById(R.id.OK_button);
        ok.setOnClickListener(buttonDetailsListener);


        Intent intent = getIntent();
        if (intent != null) {

            aux1 = intent.getStringExtra("Name");
            aux2 = intent.getStringExtra("URL");

            name.setText(aux1);
            url.setText(aux2);


        }
    }

}
