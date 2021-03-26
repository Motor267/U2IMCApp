package mx.edu.itl.c17130848.u2imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtEstatura;
    private float peso;
    private float estatura;
    private float imc = 0;
    private String men;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos las referencias a los editText de la interfaz de usuario
        edtPeso = findViewById( R.id.edtPeso );
        edtEstatura = findViewById( R.id.edtEstatura );
    }

    public void btnCalcularIMCClick ( View v ) {

        boolean bandPeso = false;
        boolean bandEstatura = false;

        if(!edtPeso.getText().toString().isEmpty()){
            peso = Float.parseFloat( edtPeso.getText().toString() );
            bandPeso = true;
        } else {
            Toast.makeText( this, "Ingrese el peso correctamente", Toast.LENGTH_SHORT ).show();
            bandPeso = false;
        }

        if(!edtEstatura.getText().toString().isEmpty()){
            estatura = Float.parseFloat( edtEstatura.getText().toString() );
            bandEstatura = true;
        } else {
            Toast.makeText( this, "Ingrese la estatura correctamente", Toast.LENGTH_SHORT ).show();
            bandEstatura = false;
        }



        if( bandPeso && bandEstatura){
            if( estatura > 0 ){
                imc = (float) ( peso / Math.pow( estatura, 2) );


            }



            if(imc > 18.5){
                men = "Peso Bajo";
            }
            if(imc > 18.5 && imc < 24.9){
                men = "Peso Normal";
            }
            if(imc > 25.0 && imc < 29.9){
                men = "Sobrepeso";
            }
            if(imc > 30.0 && imc < 34.9){
                men = "Obesidad";
            }

            // Desplegamos los resultados en un cuadro de mensaje
            AlertDialog.Builder builder = new AlertDialog.Builder( this );
            builder.setTitle( "IMC" )
                    .setMessage( "IMC = " + imc + " Tiene: " + men)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }

    }

    public void btnAcercaDeClick ( View v ) {
        //Invocamos la ejecucion del activity AcercaDeActivity
        Intent intent = new Intent( this, AcercaDeActivity.class );
        startActivity( intent );
    }
}