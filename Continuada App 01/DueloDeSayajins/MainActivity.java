 package br.com.bandtec.duelodesayajins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    private double forcaGoku = 15;
    private double forcaVegeta = 15;
    private double gokuKiValue;
    private double vegetaKiValue;
    private TextView gokuKi;
    private TextView vegetaKi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gokuKiValue = 100;
        this.vegetaKiValue = 100;
        this.gokuKi = findViewById(R.id.gokuKi);
        this.vegetaKi = findViewById(R.id.vegetaKi);
        this.setImageListeners();
    }

    public void handleClickGoku(View v) {
        if (!this.hasFightEnded()) {
            this.gokuKiValue = this.apanhar("Vegeta", this.gokuKiValue, this.forcaVegeta);
            updateTextKiAmount(this.gokuKi, this.gokuKiValue);
        }
    }

    public void handleClickVegeta(View v) {
        if (!this.hasFightEnded()) {
            this.vegetaKiValue = this.apanhar("Goku", this.vegetaKiValue, this.forcaGoku);
            updateTextKiAmount(this.vegetaKi, this.vegetaKiValue);
        }
    }

    private boolean hasFightEnded() {
        if (this.gokuKiValue <= 0 || this.vegetaKiValue <= 0) {
            Toast.makeText(this, "A luta já terminou!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void updateTextKiAmount(TextView v, double ki) {
        v.setText("Ki: " + ki);
    }

    private void setImageListeners() {
        ImageView gokuImg = findViewById(R.id.gokuImg);
        ImageView vegetaImg = findViewById(R.id.vegetaImg);
        gokuImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
				if (!hasFightEnded()) {
					forcaGoku = forcaGoku * 1.1;
				}
				return false;
            }
        });
        vegetaImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
				if (!hasFightEnded()) {
					forcaVegeta = forcaVegeta * 1.1;
				}
				return false;
            }
        });
    }

    private double apanhar(String enemySayajinName, double kiValue, double forcaOponente) {
        double diff = kiValue - forcaOponente;
        if (diff <= 0) {
            this.setWinner(enemySayajinName);
            return 0;
        }
        return diff;
    }

     private void setWinner(String winner) {
         TextView textResult = findViewById(R.id.textResult);
         textResult.setText(winner + " venceu a luta!");
     }
}
