package com.nanolabs.bolamagica;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
 private BolaDeCristal Bola = new BolaDeCristal ();
 private TextView Respuesta_etiqueta;
 private Button Obtener;
 private ImageView bolaMagicaImagen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		///agregando al Layout
		Respuesta_etiqueta = (TextView) findViewById(R.id.textView1);
		Obtener = (Button) findViewById(R.id.button1);
		bolaMagicaImagen = (ImageView) findViewById(R.id.imageView1);
		
		Obtener.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String Respuesta = Bola.ObtenerRespuesta();
				
				
				//Texto en la etiqueta
				Respuesta_etiqueta.setText(Respuesta);
				Respuesta_etiqueta.setTextColor(0xFF000000);
				
				animarBolaMagica();
				respuestaDesaparecer();
				
				
			}
		});
	}
	
	//animacion del fondo
	private void animarBolaMagica(){		
		bolaMagicaImagen.setImageResource(R.drawable.ball_animation);
		AnimationDrawable bolaAnimacion = (AnimationDrawable) bolaMagicaImagen.getDrawable();
		if (bolaAnimacion.isRunning()){
			bolaAnimacion.stop();		
		}
		bolaAnimacion.start();
	}
	
	//desvanecimiento de la etiqueta
	private void respuestaDesaparecer(){
		AlphaAnimation desaparecer = new AlphaAnimation(0, 1);
		desaparecer.setDuration(1500);
		desaparecer.setFillAfter(true);
		
		Respuesta_etiqueta.setAnimation(desaparecer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
