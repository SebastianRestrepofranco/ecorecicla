package com.sebastian.ecorecicla;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNombre, etEmail, etCiudad;
    private RadioGroup rgExperiencia;
    private CheckBox cbPlastico, cbPapel, cbVidrio;
    private Spinner spFrecuencia;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // Inicializar campos
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etCiudad = findViewById(R.id.etCiudad);
        rgExperiencia = findViewById(R.id.rgExperiencia);
        cbPlastico = findViewById(R.id.cbPlastico);
        cbPapel = findViewById(R.id.cbPapel);
        cbVidrio = findViewById(R.id.cbVidrio);
        spFrecuencia = findViewById(R.id.spFrecuencia);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recopilar datos del formulario
                String nombre = etNombre.getText().toString();
                String email = etEmail.getText().toString();
                String ciudad = etCiudad.getText().toString();

                // Obtener nivel de experiencia seleccionado
                int radioId = rgExperiencia.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(radioId);
                String experiencia = radioButton.getText().toString();

                // Obtener materiales seleccionados
                StringBuilder materiales = new StringBuilder();
                if (cbPlastico.isChecked()) materiales.append("Plástico, ");
                if (cbPapel.isChecked()) materiales.append("Papel, ");
                if (cbVidrio.isChecked()) materiales.append("Vidrio, ");

                // Eliminar última coma si existe
                String materialesStr = materiales.toString();
                if (materialesStr.endsWith(", ")) {
                    materialesStr = materialesStr.substring(0, materialesStr.length() - 2);
                }

                // Obtener frecuencia seleccionada
                String frecuencia = spFrecuencia.getSelectedItem().toString();

                // Pasar datos a la siguiente actividad
                Intent intent = new Intent(FormularioActivity.this, AceptacionActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("email", email);
                intent.putExtra("ciudad", ciudad);
                intent.putExtra("experiencia", experiencia);
                intent.putExtra("materiales", materialesStr);
                intent.putExtra("frecuencia", frecuencia);
                startActivity(intent);
            }
        });
    }
}
