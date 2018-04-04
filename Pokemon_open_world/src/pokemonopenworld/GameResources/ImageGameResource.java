/* 
 *                                                                          
 *   _____     _                                                         _   _ 
 *  |  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *  |   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *  |__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                         |_|
 *  10.02.2018
 */
package pokemonopenworld.GameResources;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import javax.imageio.*;

/**
 *
 * @author
 */
public class ImageGameResource extends GameResource {
    private Image image;

    public ImageGameResource(String name, URL path) throws MalformedURLException {
        super(name, path);
        image = null;
    }
   
    @Override
    public boolean load(){
        try{
        image = ImageTransparentBackgroundConverter.makeBackgroundTransparent(ImageIO.read(path));
        }catch(IOException e){
            //copy from default pack I guess
        }

       if(getEmpty())
           failCount++;
       else{
           System.out.print(failCount);
           failCount = 0;
       }
           
        return !getEmpty();
    }
    
    public void setImage(Image image){
        this.image = image;
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
        toReturn += "image game resource located on path \"" + path;
        toReturn += "\" and called \"" + name + "\" and ";
        if(!getEmpty())
            toReturn += "sized " + image.getWidth(null) + "x" + image.getHeight(null);
        else{
            toReturn += "empty";
        }
        return toReturn;
    }
}
