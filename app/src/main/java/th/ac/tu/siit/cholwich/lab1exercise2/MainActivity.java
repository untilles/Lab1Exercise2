package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnConvert(View v) {
        EditText etInput = (EditText) findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        double input = Double.parseDouble(s);
        double output = 0;


        RadioGroup rgFrom = (RadioGroup) findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();
        RadioGroup rgTo = (RadioGroup) findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();

        if (selFrom == R.id.rbFrmC && selTo == R.id.rbToC) { //C-C
            output = input;
        } else if (selFrom == R.id.rbFrmC && selTo == R.id.rbToF) { //C-F
            output = input*(9.0/5.0)+32;
        } else if (selFrom == R.id.rbFrmC && selTo == R.id.rbToK) { //C-K
            output = input+273.15;
        } else if (selFrom == R.id.rbFrmF && selTo == R.id.rbToC) { //F-C
            output = (input-32)*(5.0/9.0);
        } else if (selFrom == R.id.rbFrmF && selTo == R.id.rbToF) { //F-F
            output = input;
        } else if (selFrom == R.id.rbFrmF && selTo == R.id.rbToK) { //F-K
            output = (input+459.67)*(5.0/9.0);
        } else if (selFrom == R.id.rbFrmK && selTo == R.id.rbToC) { //K-C
            output = input-273.15;
        } else if (selFrom == R.id.rbFrmK && selTo == R.id.rbToF) { //K-F
            output = input*(9.0/5.0)-459.67;
        } else if (selFrom == R.id.rbFrmK && selTo == R.id.rbToK) { //K-K
            output = input;
        }

        TextView tv = (TextView)findViewById(R.id.tvOutput);
        tv.setText(Double.toString(output));

    }


}
