package br.com.bossini.gasolinaouetanol;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView gas;
    private TextView etanol;
    private Button btnCalculate;
    private TextInputEditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gas = (TextView) findViewById(R.id.gasTextView);
        SeekBar gasSeekBar = (SeekBar) findViewById(R.id.gasSeekBar);
        //String gas_value = MainActivity.getString(R.string.gas_value);
        gasSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float value = ((float)progress / 100);
                gas.setText("Gas: R$ "+value );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        etanol = (TextView) findViewById(R.id.etanolTextView);
        SeekBar etanolSeekBar = (SeekBar) findViewById(R.id.etanolSeekBar);
        //String etanol_value = MainActivity.getString(R.string.etanol_value);
        etanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float value = ((float)progress / 100);
                etanol.setText("Etanol: R$ "+value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        result = (TextInputEditText) findViewById(R.id.resultInputEditText);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtPrecoEtanol = etanol.getText().toString();
                String txtPrecoGas = gas.getText().toString();
                Double valorEtanol = Double.parseDouble(txtPrecoEtanol);
                Double valorGas = Double.parseDouble(txtPrecoGas);

                double res = valorEtanol / valorGas;

                if(res <= 0.7){
                    result.setText("Etanol");
                }else{
                    result.setText("Gasolina");
                }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
