package cl.camiletti.happyFeetWeb.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResizerUtil {

	public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight)
			throws IOException {
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);

		// creates output image
		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();

		// extracts extension of output file
		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);

		// writes to output file
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}

	public static void resize(String inputImagePath, String outputImagePath, double percent) throws IOException {
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);
		int scaledWidth = (int) (inputImage.getWidth() * percent);
		int scaledHeight = (int) (inputImage.getHeight() * percent);
		resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	}

	/**
	 * Test resizing images
	 */
	public static void main(String[] args) {
		String inputImagePath = "C:/DOCS/foto.jpg";
		String outputImagePath1 = "C:/DOCS/foto_Fixed.jpg";
		String outputImagePath2 = "C:/DOCS/foto_Smaller.jpg";
		String outputImagePath3 = "C:/DOCS/foto_test.jpg";

		try {
			// resize to a fixed width (not proportional)
			int scaledWidth = 1024;
			int scaledHeight = 768;
			ImageResizerUtil.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

			// resize smaller by 50%
			double percent = 0.5;
			ImageResizerUtil.resize(inputImagePath, outputImagePath2, percent);
			
			 percent = 0.8;
			ImageResizerUtil.resize(inputImagePath, outputImagePath3, percent);

			// resize bigger by 50%
//			percent = 1.5;
//			ImageResizerUtil.resize(inputImagePath, inputImagePath, percent);

		} catch (IOException ex) {
			System.out.println("Error resizing the image.");
			ex.printStackTrace();
		}
	}
}