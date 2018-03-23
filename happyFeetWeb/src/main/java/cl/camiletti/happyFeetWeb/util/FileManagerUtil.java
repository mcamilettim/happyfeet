package cl.camiletti.happyFeetWeb.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerUtil {

	public static final String ROOT_PATH = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0
			? "C:/repository/tesis/happyFeetWeb/src/main/webapp/resources/imagenes"
			: "/opt";
	public static final String DIR_SINGLE = "DOCS";

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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return DIR_SINGLE + File.separator + seccion + File.separator + serverFilearchivoEntrada.getName();
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

	private static byte[] loadFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		is.close();
		return bytes;
	}

	public static String encodeFileToBase64Binary(String fileName) throws IOException {
		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		return Base64.encodeBase64String(bytes);
	}

	public static void getIcon() {
		try {

			BufferedImage originalImage = ImageIO.read(new File("C:\\repository\\tesis\\happyFeetWeb\\src\\main\\webapp\\resources\\imagenes\\DOCS\\Podologo\\17483457-1.jpg"));// change path to where file is located
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type, 100, 100);
			ImageIO.write(resizeImageJpg, "jpg", new File("C:\\repository\\tesis\\happyFeetWeb\\src\\main\\webapp\\resources\\imagenes\\DOCS\\Podologo\\17483457-1_icon.jpg")); // change path where you want																						// it save
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		return resizedImage;
	}
	public static void main(String[] args) {
		FileManagerUtil.getIcon();
	}
}
