package cl.camiletti.happyFeetWeb.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerUtil {

    private static final String ROOT_PATH = System.getProperty("user.dir");
    private static final String DIR_SINGLE = "DOCS";

	 public File subirArchivo(MultipartFile archivoEntrada){
		 File serverFilearchivoEntrada = null;
		 if(!archivoEntrada.isEmpty()){
			 try {
				byte[] bytesarchivoEntrada = archivoEntrada.getBytes();    		 
				File dir = new File(ROOT_PATH + File.separator + DIR_SINGLE);
				if (!dir.exists())
				dir.mkdirs();    		
				String nombreArchivo = archivoEntrada.getOriginalFilename();
				String ext = nombreArchivo.substring(nombreArchivo.lastIndexOf("."));
                String rutaDefinitiva = ROOT_PATH + File.separator + DIR_SINGLE + File.separator;
				String nombrePrimero = archivoEntrada.getOriginalFilename();
				serverFilearchivoEntrada = new File(rutaDefinitiva + nombreArchivo);
				int i = 0;
				while(serverFilearchivoEntrada.exists()) {
					i++;
					nombreArchivo = nombrePrimero.replace(ext, "");
					nombreArchivo = nombreArchivo + "-" + i;
					nombreArchivo = nombreArchivo + ext;
					serverFilearchivoEntrada = new File(rutaDefinitiva + nombreArchivo);
				}
				serverFilearchivoEntrada = new File(ROOT_PATH + File.separator + DIR_SINGLE + File.separator + archivoEntrada.getOriginalFilename());
				
				BufferedOutputStream streamarchivoEntrada = new BufferedOutputStream(new FileOutputStream(serverFilearchivoEntrada)); 
				 
				 
				streamarchivoEntrada.write(bytesarchivoEntrada);
				streamarchivoEntrada.close();
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
		 }
	 return serverFilearchivoEntrada;
	 }
	 
	 public File subirArchivoPaciente(MultipartFile archivoEntrada, String otroPath){
		 File serverFilearchivoEntrada = null;
		 if(!archivoEntrada.isEmpty()){
			 try {
				byte[] bytesarchivoEntrada = archivoEntrada.getBytes();    		 
				File dir = new File(ROOT_PATH + File.separator + otroPath);
				if (!dir.exists())
				dir.mkdirs();    		
				String nombreArchivo = archivoEntrada.getOriginalFilename();
				String ext = nombreArchivo.substring(nombreArchivo.lastIndexOf("."));
                String rutaDefinitiva = ROOT_PATH + File.separator + otroPath + File.separator;
				String nombrePrimero = archivoEntrada.getOriginalFilename();
				serverFilearchivoEntrada = new File(rutaDefinitiva + nombreArchivo);
				int i = 0;
				while(serverFilearchivoEntrada.exists()) {
					i++;
					nombreArchivo = nombrePrimero.replace(ext, "");
					nombreArchivo = nombreArchivo + "-" + i;
					nombreArchivo = nombreArchivo + ext;
					serverFilearchivoEntrada = new File(rutaDefinitiva + nombreArchivo);
				}
				serverFilearchivoEntrada = new File(ROOT_PATH + File.separator + otroPath + File.separator + archivoEntrada.getOriginalFilename());
				
				BufferedOutputStream streamarchivoEntrada = new BufferedOutputStream(new FileOutputStream(serverFilearchivoEntrada)); 
				 
				 
				streamarchivoEntrada.write(bytesarchivoEntrada);
				streamarchivoEntrada.close();
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
		 }
	 return serverFilearchivoEntrada;
	 }
}
