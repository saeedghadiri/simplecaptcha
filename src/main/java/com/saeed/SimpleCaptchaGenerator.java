/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saeed;

import java.io.File;
import nl.captcha.Captcha;
import nl.captcha.servlet.CaptchaServletUtil;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import nl.captcha.text.producer.NumbersAnswerProducer;
import nl.captcha.backgrounds.FlatColorBackgroundProducer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import java.awt.Color;

public class SimpleCaptchaGenerator {

    public static void main(String[] args) throws IOException {
//        String folder = args[0];
//        String img_width = args[1];
//        String img_height = args[2];
//        int num_samples = Integer.parseInt(args[3]);
        String folder = "data";
        String img_width = "160";
        String img_height = "50";
        int num_samples = 1000;;

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path dataPath = Paths.get(currentPath.toString(), folder);
        System.out.println(dataPath.toString());
        new File(dataPath.toString()).mkdirs();

        for(int i=1;i<=num_samples;i++){  
            Captcha captcha = new Captcha.Builder(Integer.parseInt(img_width), Integer.parseInt(img_height)).addText(new NumbersAnswerProducer()).addBackground(new FlatColorBackgroundProducer(Color.WHITE)).addNoise(new CurvedLineNoiseProducer()).build();

            Path filePath = Paths.get(dataPath.toString(), captcha.getAnswer()+ ".jpg");
            OutputStream out = new FileOutputStream(filePath.toString());

            CaptchaServletUtil.writeImage(out, captcha.getImage());
        }

    }
}
