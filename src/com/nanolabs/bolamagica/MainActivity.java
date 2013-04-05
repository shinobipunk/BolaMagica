package com.nanolabs.bolamagica;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanolabs.bolamagica.ShakeDetector.OnShakeListener;

/*
Elias Marin Chaparro


*/
public class MainActivity extends Activity {
	
 private BolaDeCristal Bola = new BolaDeCristal ();
 private TextView Respuesta_etiqueta; 
 private ImageView bolaMagicaImagen;
 private SensorManager sensorManager;
 private Sensor acelerometro;
 private ShakeDetector detectorMovimiento;
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		///agregando al Layout
		Respuesta_etiqueta = (TextView) findViewById(R.id.textView1);		
		bolaMagicaImagen = (ImageView) findViewById(R.id.imageView1);
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		acelerometro =  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		detectorMovimiento = new ShakeDetector(new OnShakeListener() {
			
			@Override
			public void onShake() {
				// TODO Auto-generated method stub
				obtenerNuevaRespuesta();
			}
		});
		
		
		
				
	}
	
	@Override
	public void onResume(){
		super.onResume();
		sensorManager.registerListener(detectorMovimiento, acelerometro, 
				SensorManager.SENSOR_DELAY_UI);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		sensorManager.unregisterListener(detectorMovimiento);
		
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
	
	private void playSonido (){
		MediaPlayer player = MediaPlayer.create(this, R.raw.sonidoshuin);
		player.start();
		player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void obtenerNuevaRespuesta() {
		String Respuesta = Bola.ObtenerRespuesta();
		
		
		//Texto en la etiqueta
		Respuesta_etiqueta.setText(Respuesta);
		Respuesta_etiqueta.setTextColor(0xFF000000);
		
		animarBolaMagica();
		respuestaDesaparecer();
		playSonido();
	}

}
