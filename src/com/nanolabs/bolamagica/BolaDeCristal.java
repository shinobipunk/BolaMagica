package com.nanolabs.bolamagica;

import java.util.Random;

public class BolaDeCristal {
	
	public String[] mRespuestas = {
			"Seguro",
			"Asi se decidio",
			"Todo indica que si",
			"Mi respuesta es no",
			"Yo digo que no",
			"Todo indica que no",		
			"Concentrate y pregunta de nuevo",
			"No te lo puedo decir ahora"
										
	};
	
	
	public String ObtenerRespuesta () {
		
		String Respuesta = "";
		
		//Generamos un numero al azar entre 0-2
		Random GeneradorRandom = new Random();
		int Numero = GeneradorRandom.nextInt(mRespuestas.length);
				
			Respuesta = mRespuestas[Numero];					
		
			return Respuesta;
	}

}
