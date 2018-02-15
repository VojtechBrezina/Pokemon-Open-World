/* 
 *                                                                          
 *   _____     _                                                         _   _ 
 *  |  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *  |   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *  |__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                         |_|
 *  12.02.2018
 */
package pokemonopenworld.GameResources;

import java.awt.*;
import java.awt.image.*;

/**
 *
 * @autho
 */
public class ImageTransparentBackgroundConverter {
    //copied from http://www.java2s.com/Code/Java/2D-Graphics-GUI/MakeimageTransparency.htm
    private static final Color TRANSPARENT_COLOR = new Color(255, 0, 255); 
    private static final ImageFilter FILTER = new RGBImageFilter() {
      // the color we are looking for... Alpha bits are set to opaque
      public int markerRGB = TRANSPARENT_COLOR.getRGB() | 0xFF000000;

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
    public static Image makeBackgroundTransparent(Image image) {
        ImageProducer ip = new FilteredImageSource(image.getSource(), FILTER);
        return Toolkit.getDefaultToolkit().createImage(ip);
  }
}
