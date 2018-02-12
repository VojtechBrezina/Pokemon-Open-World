/*
 *                                                                          
 *   _____     _                                                         _   _ 
 *  |  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *  |   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *  |__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                         |_|
 *  10.02.2018
 */
package pokemonopenworld.gameresources;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.net.*;

/**
 *
 * @author
 */
public class ImageGameResource extends GameResource {
    private Image image;
    private static final Color TRANSPARENT_BACKGROUND_COLOR = new Color(255, 0, 255);

    //copied from http://www.java2s.com/Code/Java/2D-Graphics-GUI/MakeimageTransparency.htm
    private static Image makeColorTransparent(Image image, final Color color) {
    ImageFilter filter = new RGBImageFilter() {
      // the color we are looking for... Alpha bits are set to opaque
      public int markerRGB = color.getRGB() | 0xFF000000;

      @Override
      public final int filterRGB(int x, int y, int rgb) {
        if ((rgb | 0xFF000000) == markerRGB) {
          // Mark the alpha bits as zero - transparent
          return 0x00FFFFFF & rgb;
        } else {
          // nothing to do
          return rgb;
        }
      }
    };

    ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
  }
    
    public ImageGameResource(String name) {
        super(name);
        image = null;
    }
    
    @Override
    public boolean load(String path){
        URL url = getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        image = icon.getImage();
        image = makeColorTransparent(image, TRANSPARENT_BACKGROUND_COLOR);
        return getEmpty();
    }
    
    public Image getImage(){
        return image;
    }
    
    @Override
    public boolean getEmpty(){
        return image == null || image.getHeight(null) == -1;
    }
    
    @Override
    public String toString(){
        String toReturn = "";
        toReturn += "image game resource called \"" + name + "\" and ";
        if(!getEmpty())
            toReturn += "sized " + image.getWidth(null) + "x" + image.getHeight(null);
        else{
            toReturn += "empty";
        }
        return toReturn;
    }
}
