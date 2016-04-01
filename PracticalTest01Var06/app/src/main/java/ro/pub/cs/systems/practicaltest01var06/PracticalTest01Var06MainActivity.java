package ro.pub.cs.systems.practicaltest01var06;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    Button Details, passorfail, navigate = null;
    LinearLayout interestArea = null;
    EditText url, name = null;
    ButtonDetailsListener buttonDetailsListener = new ButtonDetailsListener();
    ButtonPassListener buttonPassListener = new ButtonPassListener();
    ButtonCreateIntentListener buttonCreateIntentListener = new ButtonCreateIntentListener();

    private class ButtonPassListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().startsWith("http")) {
                passorfail.setText("Pass");
                passorfail.setBackground(getApplicationContext().getResources().getDrawable(R.color.green));
            } else {
                passorfail.setText("Fail");
                passorfail.setBackground(getApplicationContext().getResources().getDrawable(R.color.red));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    private class ButtonDetailsListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (Details.getText().toString() == "Less Details") {
                interestArea.setVisibility(View.INVISIBLE);
                Details.setText("More Details");
            } else {
                interestArea.setVisibility(View.VISIBLE);
                Details.setText("Less Details");
            }


        }
    }

    private class ButtonCreateIntentListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent("ro.pub.cs.systems.eim.test1.basicintentactivity2.intent.action.PracticalTest01Var06SecondaryActivity");
            intent.putExtra("Name", name.getText().toString());
            intent.putExtra("URL", passorfail.getText());


            startActivityForResult(intent, 1);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Details = (Button) findViewById(R.id.DetailsButton);
        Details.setOnClickListener(buttonDetailsListener);
        passorfail = (Button) findViewById(R.id.PassOrFail);
        interestArea = (LinearLayout) findViewById(R.id.InterestArea);

        url = (EditText) findViewById(R.id.URL);
        url.addTextChangedListener(buttonPassListener);

        navigate = (Button) findViewById(R.id.Navigate);
        navigate.setOnClickListener(buttonCreateIntentListener);

        name = (EditText) findViewById(R.id.StudentName);

        if (savedInstanceState != null) {

            Toast.makeText(getApplication(), "Name " + savedInstanceState.getString("Name") + "URL " + savedInstanceState.getString("URL"), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var06_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("Name", name.getText().toString());
        savedInstanceState.putString("URL", url.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey("Name")){
            name.setText(savedInstanceState.getString("Name"));
        }
        if(savedInstanceState.containsKey("URL")){
            name.setText(savedInstanceState.getString("URL"));
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (resultCode) {
            case RESULT_CANCELED:

                Toast.makeText(getApplication(), "cancel", Toast.LENGTH_LONG).show();

                break;
            case RESULT_OK:

                Toast.makeText(getApplication(), "OK", Toast.LENGTH_LONG).show();

                break;
        }
    }
}
