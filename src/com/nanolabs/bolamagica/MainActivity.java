package com.nanolabs.bolamagica;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
 private BolaDeCristal Bola = new BolaDeCristal ();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Declarando Variables
		final TextView Respuesta_etiqueta = (TextView) findViewById(R.id.textView1);
		Button Obtener = (Button) findViewById(R.id.button1);
		
		Obtener.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String Respuesta = Bola.ObtenerRespuesta();
				
				
				//Texto en la etiqueta
				Respuesta_etiqueta.setText(Respuesta);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
