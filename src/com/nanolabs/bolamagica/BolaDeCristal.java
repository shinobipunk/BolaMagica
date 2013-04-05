package com.nanolabs.bolamagica;

import java.util.Random;

public class BolaDeCristal {
	
	public String[] mRespuestas = {
			"Simona la cacarisa",
			"Seguro",
			"Todo indica que si",
			"Si",
			"El History Channel dice que si",
			"jajajaja NO",
			"Mi respuesta es no",
			"En tus Sueños",
			"Ohh por favor pfff",
			"Chuck Norris dice que no",		
			"Concentrate y pregunta de nuevo",
			"No te lo puedo decir ahora",
			"Creeme que no me importa"										
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
