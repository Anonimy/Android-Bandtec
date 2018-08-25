package br.com.bandtec.cofrinholokomeu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double deposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.deposito = 0;
    }

    public void handleClick(View v) {
        EditText input01 = findViewById(R.id.input01);
        EditText input02 = findViewById(R.id.input02);
        String meta = input01.getText().toString();
        this.deposito += Double.parseDouble(input02.getText().toString());
        this.setResultText(meta);
    }

    private void setResultText(String meta) {
        String textResultDescription;
        int color = Color.BLACK;
        TextView textResult = findViewById(R.id.textResult);
        TextView textResultDesc = findViewById(R.id.textResultDescription);
        if (meta == null || meta.equals("")) {
            color = Color.RED;
            textResultDescription = "Não vamos colocar meta. Vamos deixar a meta aberta, mas, quando atingirmos a meta, vamos dobrar a meta";
        } else {
            color = Color.GREEN;
            double metaValue = Double.parseDouble(meta);
            if (metaValue > this.deposito) {
                double diff = metaValue - this.deposito;
                textResultDescription = "Faltam R$" + diff + " para atingir sua meta de R$" + metaValue;
            } else {
                textResultDescription = "Parabéns! Você já atingiu sua meta!";
            }
        }
        textResult.setText("Total depositado no porquinho: R$ " + this.deposito);
        textResultDesc.setText(textResultDescription);
        textResultDesc.setTextColor(color);
    }
}
