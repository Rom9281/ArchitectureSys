package com.sp.tools;

import org.springframework.web.client.RestTemplate;

import com.model.CardDTO;

public class Comm {
	
	static RestTemplate restTemplate = new RestTemplate();
	//HttpHeaders headers = new HttpHeaders();
	
	static String URL_GENERATECARD = "http://127.0.0.1:8083/generateCards";
	
	
	
	// GET: http://localhost:8083/generateCards/{id}
		public static void generateCards(Integer id) {
			// TODO : possiblement gerer le type de retour, à mettre dans un fichier dédier pour les appels API
			//HttpEntity<Integer> request = new HttpEntity<>(id, headers);
			restTemplate.getForObject(URL_GENERATECARD+"/"+id.toString() , CardDTO[].class);

		}

}
