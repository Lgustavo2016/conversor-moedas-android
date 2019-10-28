package com.lsandoval.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // the "m" prefix is a pattern in Java, for private variables
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.value = findViewById(R.id.editValor);
        this.mViewHolder.textDollar = findViewById(R.id.textDolar);
        this.mViewHolder.textEuro = findViewById(R.id.textEuro);
        this.mViewHolder.btnCalculate = findViewById(R.id.btnCalcular);

        this.mViewHolder.btnCalculate.setOnClickListener(this);

        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textDollar.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {
            String value = this.mViewHolder.value.getText().toString();

            if ("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                this.mViewHolder.textDollar.setText("$ " + String.format("%.2f", (Double.parseDouble(value) / 4)));
                this.mViewHolder.textEuro.setText("€ " + String.format("%.2f", (Double.parseDouble(value) / 5)));
            }
        }
    }

    /*
     * We use this class to implement the "ViewHolder" pattern,
     * a pattern that guarantee that the Activity just look
     * for the Elements on the view once what avoid performance issues
     * */
    private static class ViewHolder {

        EditText value;
        TextView textDollar;
        TextView textEuro;
        Button btnCalculate;
    }

}
