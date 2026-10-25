package com.example.pmdmejercicios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


// 1. Añadimos "implements View.OnClickListener"
public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {

    // 2. Declaramos los componentes
    private TextView tvResultado;
    private EditText etNumero1, etNumero2;
    private Button btnSuma, btnResta, btnMultiplicacion, btnDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        // 3. Inicializamos con findViewById
        tvResultado = findViewById(R.id.tvResultado);
        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);

        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);

        // 4. Asignamos el Listener pasándole la propia Activity (this)
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMultiplicacion.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
    }

    // 5. Implementamos el método onClick exigido por la interfaz
    @Override
    public void onClick(View v) {
        // Comprobamos que los campos no estén vacíos para evitar cierres inesperados
        if (etNumero1.getText().toString().isEmpty() || etNumero2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Introduce ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        // Extraemos los valores
        double num1 = Double.parseDouble(etNumero1.getText().toString());
        double num2 = Double.parseDouble(etNumero2.getText().toString());
        double resultado = 0;

        // Evaluamos qué botón se ha pulsado mediante su ID
        if (v.getId() == R.id.btnSuma) {
            resultado = num1 + num2;
        } else if (v.getId() == R.id.btnResta) {
            resultado = num1 - num2;
        } else if (v.getId() == R.id.btnMultiplicacion) {
            resultado = num1 * num2;
        } else if (v.getId() == R.id.btnDivision) {
            if (num2 == 0) {
                Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show(); // Notificación simple emergente
                return;
            }
            resultado = num1 / num2;
        }

        // Mostramos el resultado
        tvResultado.setText(String.valueOf(resultado));
    }
}
