package cl.camiletti.happyFeetWeb.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerUtil {

	// public static final String ROOT_PATH =
	// System.getProperty("os.name").toLowerCase().indexOf("win") >= 0
	// ? "C:/repository/tesis/happyFeetWeb/src/main/webapp/resources/imagenes"
	// : "/opt";
	private UtilProperties util;
	private String ROOT_PATH;
	private String DIR_SINGLE;

	public FileManagerUtil() {
		this.util = new UtilProperties();
		this.ROOT_PATH = this.util.getProperty(Properties.ROOT_PATH);
		this.DIR_SINGLE = this.util.getProperty(Properties.DIR_SINGLE);
	}

	public String subirArchivo(MultipartFile archivoEntrada, String seccion, String rut) {

		File serverFilearchivoEntrada = null;
		if (!archivoEntrada.isEmpty()) {
			try {
				byte[] bytesarchivoEntrada = archivoEntrada.getBytes();
				File dir = new File(ROOT_PATH + File.separator + DIR_SINGLE + File.separator + seccion);
				if (!dir.exists())
					dir.mkdirs();
				String nombreArchivo = archivoEntrada.getOriginalFilename();
				String ext = nombreArchivo.substring(nombreArchivo.lastIndexOf("."));
				String rutaDefinitiva = ROOT_PATH + File.separator + DIR_SINGLE + File.separator + seccion
						+ File.separator;
				nombreArchivo = rut + ext;
				String nombrePrimero = nombreArchivo + ext;
				serverFilearchivoEntrada = new File(rutaDefinitiva + nombreArchivo);
				int i = 0;
				while (serverFilearchivoEntrada.exists()) {
					i++;
					nombreArchivo = nombrePrimero.replace(ext, "");
					nombreArchivo = nombreArchivo + "-" + i;
					nombreArchivo = nombreArchivo + ext;
					serverFilearchivoEntrada = new File(rutaDefinitiva + nombreArchivo);
				}
				// serverFilearchivoEntrada = new File(ROOT_PATH + File.separator + DIR_SINGLE +
				// File.separator + archivoEntrada.getOriginalFilename());

				BufferedOutputStream streamarchivoEntrada = new BufferedOutputStream(
						new FileOutputStream(serverFilearchivoEntrada));
				streamarchivoEntrada.write(bytesarchivoEntrada);
				streamarchivoEntrada.close();
				return DIR_SINGLE + File.separator + seccion + File.separator + serverFilearchivoEntrada.getName();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}

	}

	public File subirArchivoPaciente(MultipartFile archivoEntrada, String otroPath) {
		File serverFilearchivoEntrada = null;
		if (!archivoEntrada.isEmpty()) {
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
				while (serverFilearchivoEntrada.exists()) {
					i++;
					nombreArchivo = nombrePrimero.replace(ext, "");
					nombreArchivo = nombreArchivo + "-" + i;
					nombreArchivo = nombreArchivo + ext;
					serverFilearchivoEntrada = new File(rutaDefinitiva + nombreArchivo);
				}
				serverFilearchivoEntrada = new File(
						ROOT_PATH + File.separator + otroPath + File.separator + archivoEntrada.getOriginalFilename());

				BufferedOutputStream streamarchivoEntrada = new BufferedOutputStream(
						new FileOutputStream(serverFilearchivoEntrada));

				streamarchivoEntrada.write(bytesarchivoEntrada);
				streamarchivoEntrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return serverFilearchivoEntrada;
	}

	private static byte[] loadFile(File file) {
		InputStream is = null;
		byte[] bytes = null;
		try {
			is = new FileInputStream(file);
			long length = file.length();
			bytes = new byte[(int) length];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}

		}

		return bytes;
	}

	public String getPathImageFromUrl(String linkedin, String rutPaciente,String rutPodologo, String seccion) {
		try {
			String link = "http://maps.googleapis.com/maps/api/staticmap?sensor=false&&zoom=14&size=700x500&markers=color:blue%7&path=enc:z%7CrkE~k%7BnLEeRhBIpBEVBPBJCDK?a@ISGGu@mAkCeE%7DHsMI_@MW%7B@%7BAAKEIuAmByAcBWU%5BIqJFqDB%7DEAgGAm@?uBZsDKyACw@DSDoA%5C%5BNe@ZwBjBu@n@g@POL_@Vu@%60@u@VcAVwAHiDMyO%7B@iEIyGYaGc@kIo@sDUcM_AcAILoANBNCH_@XyC";
			String pathImage = ROOT_PATH + File.separator + DIR_SINGLE + File.separator + seccion + File.separator;
			String ext =".jpg";
			String nameFile= rutPaciente+rutPodologo+ext;
			URL url = new URL(link);
			InputStream in = new BufferedInputStream(url.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			byte[] response = out.toByteArray();
	 
			File serverFilearchivoEntrada = new File(pathImage + nameFile);
			int i = 0;
			while (serverFilearchivoEntrada.exists()) {
				i++;
				nameFile = nameFile.replace(ext, "");
				nameFile = nameFile + "-" + i;
				nameFile = nameFile + ext;
				serverFilearchivoEntrada = new File(pathImage + nameFile);
			}
			FileOutputStream fos = new FileOutputStream(nameFile);
			fos.write(response);
			fos.close();
			return  DIR_SINGLE + File.separator + seccion + File.separator + nameFile;
		} catch (Exception e) {
			return null;
		}

	}

	public String encodeFileToBase64Binary(String fileName) {
		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		if (bytes != null)
			return Base64.encodeBase64String(bytes);
		else
			return null;
	}

	public UtilProperties getUtil() {
		return util;
	}

	public void setUtil(UtilProperties util) {
		this.util = util;
	}

	public String getROOT_PATH() {
		return ROOT_PATH;
	}

	public void setROOT_PATH(String rOOT_PATH) {
		ROOT_PATH = rOOT_PATH;
	}

	public String getDIR_SINGLE() {
		return DIR_SINGLE;
	}

	public void setDIR_SINGLE(String dIR_SINGLE) {
		DIR_SINGLE = dIR_SINGLE;
	}

}
