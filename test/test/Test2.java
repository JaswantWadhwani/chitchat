/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import chitchat.swing.utilities.blurhash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Jatin Wadhwani
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("D:\\JavaProjectCoaching\\ChitChat\\src\\chitchat\\icons\\icon.png"));
            String blurhashStr = BlurHash.encode(image);
            System.out.println(blurhashStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
