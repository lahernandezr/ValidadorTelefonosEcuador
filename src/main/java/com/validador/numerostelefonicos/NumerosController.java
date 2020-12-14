package com.validador.numerostelefonicos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Validador de números telefonicos de Ecuador
 * @author Ing. Luis Angel Hernandez Rodriguez
 * 
 */

@Controller
public class NumerosController {
    
    
    @GetMapping("/validador/{phone}")
    @ResponseBody
	public ResponseNumber validador(@PathVariable String phone) {
        ResponseNumber responseNumber = new ResponseNumber();
        if(phone == null){     // Se valida que no sea nulo
            responseNumber.setError(1);
            responseNumber.setMessage("Número de telefonía no valido: " + phone);
            responseNumber.setProvincia("");
        }
        else
        if(phone.equals("")){ // Se valida que no sea una cadena vacia
            responseNumber.setError(1);
            responseNumber.setMessage("Número de telefonía no valido: " + phone);
            responseNumber.setProvincia("");
        }
        else
        if(!(phone.length() == 10)){ // Se valida que su longitud no sea mayor de 10
            responseNumber.setError(1);
            responseNumber.setMessage("Número de telefonía no valido: " + phone);
            responseNumber.setProvincia("");
        
        }
        else
        if(!phone.matches("[0-9]+")){  //Se valida que contenga números del 0 al 9
            responseNumber.setError(1);
            responseNumber.setMessage("Número de telefonía no valido: " + phone);
            responseNumber.setProvincia("");

        }
        else{

            responseNumber.setError(0);
            responseNumber.setMessage("Numero de telefonia fija");
            if(phone.substring(0, 2).equals("02")){    // Si los primeros 2 numeros son 02 entra a la validación
                responseNumber.setProvincia("Pichincha,Sto. Domingo");
            }
            else
            if(phone.substring(0, 2).equals("03")){ // Si los primeros 2 numeros son 03 entra a la validación
                responseNumber.setProvincia("Tungurahua, Cotopaxi,Chimborazo, Bolívar, Pastaza");
            }
            else
            if(phone.substring(0, 2).equals("04")){ // Si los primeros 2 numeros son 04 entra a la validación
                responseNumber.setProvincia("Guayas, Sta. Elena");
            }
            else
            if(phone.substring(0, 2).equals("05")){ // Si los primeros 2 numeros son 05 entra a la validación
                responseNumber.setProvincia("Galápagos, Manabí, Los Ríos");
            }
            else
            if(phone.substring(0, 2).equals("06")){ // Si los primeros 2 numeros son 06 entra a la validación
                responseNumber.setProvincia("Esmeraldas, Carchi, Imbabura, Sucumbíos, Orellana, Napo");
            }
            else
            if(phone.substring(0, 2).equals("07")){ // Si los primeros 2 numeros son 07 entra a la validación
                responseNumber.setProvincia("El Oro, Azuay, Cañar, Loja, Morona Santiago, Zamora");
            }  
            else
            if(phone.substring(0, 2).equals("08") || phone.substring(0, 2).equals("09")){ // Si los primeros 2 numeros son 08 o 09 entra a la validación
                responseNumber.setMessage("Número de telefonia movil");
                responseNumber.setProvincia("");
            }   
            else{ // Sino es ninguna de las anteriores no es un numero valido
                responseNumber.setError(1);
                responseNumber.setMessage("Número de telefonía no valido");
            }         
            

        }
        
		return responseNumber;
	}

}
