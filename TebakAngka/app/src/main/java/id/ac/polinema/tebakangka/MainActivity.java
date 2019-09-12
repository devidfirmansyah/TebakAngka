package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //  TODO: deklarasikan variabel di sini
    private EditText etAngka;
    int angkaRandom = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: bind layout di sini
        etAngka = (EditText) findViewById(R.id.number_input);
    }

    // TODO: generate angka random di sini
    private void initRandomNumber() {
        Random Angka = new Random();
        if(angkaRandom == 0){
            angkaRandom = Angka.nextInt(100);
        }
        else{
            angkaRandom = angkaRandom;
        }
    }

    public void handleGuess(View view) {
        initRandomNumber();
        // TODO: Tambahkan logika untuk melakukan pengecekan angka
        if (etAngka.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Masukkan Angka!!!", Toast.LENGTH_SHORT).show();
        } else {
            if (angkaRandom < Integer.parseInt(etAngka.getText().toString())) {
                Toast.makeText(this, "Tebakan Anda Lebih Besar", Toast.LENGTH_SHORT).show();
                etAngka.setText("");
            } else if (angkaRandom > Integer.parseInt(etAngka.getText().toString())) {
                Toast.makeText(this, "Tebakan Anda Lebih Kecil", Toast.LENGTH_SHORT).show();
                etAngka.setText("");
            } else {
                Toast.makeText(this, "Tebakan Anda Benar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void handleReset(View view) {
        // TODO: Reset tampilan
        angkaRandom = 0;
        initRandomNumber();
        etAngka.setText("");
        Toast.makeText(this, "Reset Berhasil", Toast.LENGTH_SHORT).show();
    }
}
