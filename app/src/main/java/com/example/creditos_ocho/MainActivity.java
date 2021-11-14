package com.example.creditos_ocho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton jrbEmprendimiento, jrbInteligencia, jrbAuditoria, jrbSeguridad;
    TextView jtvTotal, jtvPrecioIngles, jtvCre, jtvMats;
    EditText jetValCre, jetCantCre;
    CheckBox jcbIngles;
    Button jbtCalc, jbtLimp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jrbEmprendimiento = findViewById(R.id.rbEmprendimiento);
        jrbInteligencia = findViewById(R.id.rbInteligencia);
        jrbAuditoria = findViewById(R.id.rbAuditoria);
        jrbSeguridad = findViewById(R.id.rbSeguridad);
        jtvTotal = findViewById(R.id.tvTotal);
        jtvPrecioIngles = findViewById(R.id.tvPrecioIngles);
        jtvCre = findViewById(R.id.tvCre);
        jtvMats = findViewById(R.id.tvMats);
        jetValCre = findViewById(R.id.etValCre);
        jetCantCre = findViewById(R.id.etCantCre);
        jcbIngles = findViewById(R.id.cbIngles);
        jbtCalc = findViewById(R.id.btCalc);
        jbtLimp = findViewById(R.id.btLimp);

        jrbEmprendimiento.setChecked(true);
        jcbIngles.setChecked(false);
        jetValCre.requestFocus();
    }

    public void calc_tot(){
        String valor, cant;
        valor = jetValCre.getText().toString();
        cant = jetCantCre.getText().toString();

        if(valor.isEmpty()){
            Toast.makeText(this,"Ingrese el valor para continuar", Toast.LENGTH_LONG).show();
            jetValCre.requestFocus();
        }else if(cant.isEmpty()){
            Toast.makeText(this,"Ingrese la cantidad para continuar", Toast.LENGTH_LONG).show();
            jetCantCre.requestFocus();
        }else{
            int val_cre, cant_cre, val_mat, mat_add, val_ing, val_tot;

            val_cre = Integer.parseInt(valor);
            cant_cre = Integer.parseInt(cant);

            mat_add = Integer.parseInt(jtvMats.getText().toString());
            val_mat = val_cre * cant_cre;


            val_ing = Integer.parseInt(jtvPrecioIngles.getText().toString());

            val_tot = val_mat + val_ing +mat_add;

            jtvMats.setText(String.valueOf(mat_add));
            jtvCre.setText(String.valueOf(val_mat));
            jtvTotal.setText(String.valueOf(val_tot));
        }
    }

    public void calc (View view){
        calc_tot();
    }

    public void Emprendimiento(View view){
        jtvMats.setText("280000");
        calc_tot();
    }

    public void Inteligencia(View view){
        jtvMats.setText("310000");
        calc_tot();
    }

    public void Audioria(View view){
        jtvMats.setText("355000");
        calc_tot();
    }

    public void Seguridad(View view){
        jtvMats.setText("400000");
        calc_tot();
    }

    public void Ingles(View view){
        if(jcbIngles.isChecked()){
            jtvPrecioIngles.setText("180000");
        }else{
            jtvPrecioIngles.setText("0");
        }
        calc_tot();
    }

    public void Limpiar(View view){
        jetValCre.setText("");
        jetCantCre.setText("");
        jtvCre.setText("");
        jrbEmprendimiento.setChecked(true);
        jtvMats.setText("280000");
        jcbIngles.setChecked(false);
        jtvPrecioIngles.setText("0");
        jtvTotal.setText("0");
        jetValCre.requestFocus();
    }
}