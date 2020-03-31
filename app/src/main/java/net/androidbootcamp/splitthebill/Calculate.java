package net.androidbootcamp.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculate extends AppCompatActivity {
    double bill;
    double percentTip = 0.18;
    double totalTip;
    int numberOfGuests;
    double totalBillPlusTip;
    double costPerGuest;
    double tipPerGuest;
    String qualitySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        final EditText billAmount = (EditText) findViewById(R.id.txtTotal);
        final Spinner serviceQuality = (Spinner)findViewById(R.id.txtServiceQuality);
        final EditText numGuests = (EditText)findViewById(R.id.txtGuests);
        final TextView result = ((TextView)findViewById(R.id.txtResult));

        Button buttonSplit = (Button)findViewById(R.id.btnSplit);

        buttonSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bill = Double.parseDouble(billAmount.getText().toString());
                totalTip = percentTip * bill;
                totalBillPlusTip = bill + totalTip;

                numberOfGuests = Integer.parseInt(numGuests.getText().toString());
                costPerGuest = totalBillPlusTip / numberOfGuests;
                tipPerGuest = totalTip / numberOfGuests;
                qualitySelected = serviceQuality.getSelectedItem().toString();
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                result.setText("The total tip at 18% for a " + qualitySelected + " service is " + currency.format(totalTip) +
                        ", the individual tip amount among " + numberOfGuests + " guests is " + currency.format(tipPerGuest) + " and " +
                        "the individual share for each guest including tip is " + currency.format(costPerGuest));

            }
        });
    }
}
