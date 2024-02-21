package de.tekup.tp1mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText amountTextNumberDecimal;
    private RadioButton TndToEuroRadioButton;
    private RadioButton EuroToTndRadioButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountTextNumberDecimal = (EditText) findViewById(R.id.amountTextNumberDecimal);
        TndToEuroRadioButton = (RadioButton) findViewById(R.id.TndToEuroRadioButton);
        EuroToTndRadioButton = (RadioButton) findViewById(R.id.EuroToTndRadioButton);
        resultText = (TextView) findViewById(R.id.resultText);
    }

    public void convertCurrency(View view) {
        if (amountTextNumberDecimal.getText().toString().isEmpty()) {
            Toast
                    .makeText(this, "Please enter an amount to convert", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        double amount = Double.parseDouble(amountTextNumberDecimal.getText().toString());
        if (amount <= 0) {
            Toast
                    .makeText(this, "Please enter a positive amount to convert", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (!TndToEuroRadioButton.isChecked() && !EuroToTndRadioButton.isChecked()) {
            Toast
                    .makeText(this, "Please select a currency to convert", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TndToEuroRadioButton.isChecked()) {
            resultText.setText(getString(R.string.result, amount / 3.4, " Euros"));
        } else if (EuroToTndRadioButton.isChecked()) {
            resultText.setText(getString(R.string.result, amount * 3.4, " Dinars"));
        }
    }
}