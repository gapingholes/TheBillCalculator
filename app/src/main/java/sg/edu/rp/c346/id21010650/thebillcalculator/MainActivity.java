package sg.edu.rp.c346.id21010650.thebillcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button buttSplit;
    Button buttReset;
    RadioButton rgPaynow;
    RadioButton rgCash;
    ToggleButton toggleSVS;
    ToggleButton toggleGST;
    EditText etDiscount;
    EditText etAmount;
    EditText etPax;
    TextView totalBill;
    TextView eachPay;
    RadioGroup rgPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttSplit = findViewById(R.id.buttSplit);
        buttReset = findViewById(R.id.buttReset);
        rgPaynow = findViewById(R.id.rgPaynow);
        rgCash = findViewById(R.id.rgCash);
        toggleSVS = findViewById(R.id.toggleSVS);
        toggleGST = findViewById(R.id.toggleGST);
        etDiscount = (EditText) findViewById(R.id.etDiscount);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etPax = (EditText) findViewById(R.id.etPax);
        totalBill = findViewById(R.id.totalBill);
        eachPay = findViewById(R.id.eachPay);


    buttSplit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (etAmount.getText().toString().length() == 0) etPax.getText().toString().length();
         else {
            }
            String data1 = etAmount.getText().toString();
            String data2 = etPax.getText().toString();

            double amount = Double.parseDouble(data1);
            double newAmount = 0;
            int pax = Integer.parseInt(data2);

            if (toggleGST.isChecked() == true && toggleSVS.isChecked() == true) {
                newAmount = amount * 1.10 * 1.07;
            } else if (toggleGST.isChecked() == false && toggleSVS.isChecked() == true) {
                newAmount = amount * 1.10;
            } else if (toggleGST.isChecked() == true && toggleSVS.isChecked() == false) {
                newAmount = amount * 1.07;
            } else {
                newAmount = amount;
            }

            double eachPays = newAmount / pax;
            totalBill.setText("Total Amount: $" + newAmount + "" );

            String msg = String.format("%.2f", eachPays);
            eachPay.setText("Each pays: $" + msg + "");
        }
    });
    }
}