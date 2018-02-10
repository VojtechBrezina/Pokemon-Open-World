/*
 *                                                                          
 *   _____     _                                                         _   _ 
 *  |  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *  |   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *  |__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                         |_|
 *  10.02.2018
 */
package pokemonopenworld;

import java.awt.*;
import java.awt.image.*;
import pokemonopenworld.GameResource;

/**
 *
 * @author Vojta
 */
public class AtlasGameResource extends GameResource {
    private Image atlasImage;
    //private int 
    
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
    
    public AtlasGameResource(String name) {
        super(name);
    }
    
    
}
