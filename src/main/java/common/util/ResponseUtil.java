/**
 * 
 */
package common.util;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * @author Leosvel Pérez Espinosa
 *
 */
public class ResponseUtil {

	/**
	 * Función que se le pasa el json para escribirlo en 
	 * el response.
	 * @param response (HttpServletResponse)
	 * @param json (JSONObject)
	 * @throws IOException
	 */
	public static void escribirDatosEnElResponse(HttpServletResponse response, JSONObject json)
			throws IOException{
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("ISO-8859-1");
		ServletOutputStream out = response.getOutputStream();		
		out.print(json.toString());
		out.close();
	}
	
	/**
	 * Función que se le pasan los datos en forma de String para escribirlos en 
	 * el response.
	 * @param response (HttpServletResponse)
	 * @param data (String)
	 * @throws IOException
	 */
	public static void escribirDatosEnElResponse(HttpServletResponse response, String data)
			throws IOException{
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("ISO-8859-1");
		ServletOutputStream out = response.getOutputStream();		
		out.print(data);
		out.close();
	}

	
	
}
