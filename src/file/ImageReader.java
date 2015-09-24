package file;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Console;

public class ImageReader {
	public static Image getImage(String path){
	 try {
		return ImageIO.read(new File(path));
	} catch (IOException e) {
		Console.console.warn("cannot find image: "+path.substring(path.lastIndexOf('/')+1,path.length()));
		try {
			return ImageIO.read(new File("assets/misc/missing.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}
}
}
