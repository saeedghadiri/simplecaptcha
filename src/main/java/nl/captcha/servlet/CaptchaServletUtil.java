package nl.captcha.servlet;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public final class CaptchaServletUtil {
    public static void writeImage(OutputStream os, BufferedImage bi) {
    	try {
			ImageIO.write(bi, "png", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
