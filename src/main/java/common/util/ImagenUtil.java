package common.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagenUtil {
	private static final float IMAGE_DIMENSIONS = 150;
	
	public static byte[] scaleJPGImage(byte[] originalImage) throws  IOException {
//		ByteArrayInputStream bais = new ByteArrayInputStream(originalImage);
//		BufferedInputStream bis = new BufferedInputStream(bais);		
//		com.sun.image.codec.jpeg.JPEGImageDecoder decoder = JPEGCodec
//				.createJPEGDecoder(bis);
//		BufferedImage bufferedImage = decoder.decodeAsBufferedImage();
//		
//		bufferedImage =  scaleBufferedJPGImage(bufferedImage);
//		
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		BufferedOutputStream bai = new BufferedOutputStream(baos);
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bai);
//		 encoder.encode(bufferedImage);
//		return baos.toByteArray();
		return new byte[1];
	}
	

	public static BufferedImage scaleBufferedJPGImage(BufferedImage originalImage) throws 
			IOException {
          float height = Float.parseFloat(originalImage.getHeight() + "" );
          float width = Float.parseFloat(originalImage.getWidth() + "");
          
         height = IMAGE_DIMENSIONS < height ? IMAGE_DIMENSIONS / height : 1;
		 width = IMAGE_DIMENSIONS < width ? IMAGE_DIMENSIONS / width : 1;
		
		AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(width,height), null);
		
		BufferedImage imageResult = op.filter(originalImage, null);
		return imageResult;
	}
	
	
	public static void borrarImagenDeCarpeta(String pathName) throws Exception{
		File containerFolder = new File(pathName);
		File[] childs = containerFolder.listFiles();
		
		for (int i = 0; i < childs.length; i++)
		   childs[i].delete();
			
	}
}
