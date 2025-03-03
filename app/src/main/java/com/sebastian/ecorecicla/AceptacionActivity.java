package com.sebastian.ecorecicla;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AceptacionActivity extends AppCompatActivity {

    private TextView tvResumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptacion);

        tvResumen = findViewById(R.id.tvResumen);

        // Recuperar datos del intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre");
            String email = extras.getString("email");
            String ciudad = extras.getString("ciudad");
            String experiencia = extras.getString("experiencia");
            String materiales = extras.getString("materiales");
            String frecuencia = extras.getString("frecuencia");

            // Mostrar resumen
            String resumen = "¡Registro Completado!\n\n" +
                    "Nombre: " + nombre + "\n" +
                    "Email: " + email + "\n" +
                    "Ciudad: " + ciudad + "\n" +
                    "Experiencia en reciclaje: " + experiencia + "\n" +
                    "Materiales que recicla: " + materiales + "\n" +
                    "Frecuencia de reciclaje: " + frecuencia + "\n\n" +
                    "¡Gracias por unirte a EcoRecicla! Juntos podemos marcar la diferencia.";

            tvResumen.setText(resumen);
        }
    }
}