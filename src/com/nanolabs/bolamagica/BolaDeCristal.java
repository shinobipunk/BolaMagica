package com.nanolabs.bolamagica;

import java.util.Random;

public class BolaDeCristal {
	
	public String[] mRespuestas = {
			"Seguro",
			"Asi se decidio",
			"Todo indica que si",
			"Las estrellas no estan alineadas",
			"Yo digo que no",
			"Es dudoso",
			"Mejor no te lo digo ahora",
			"Concentrate y pregunta de nuevo",
			"No te puedo contestar"							
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
