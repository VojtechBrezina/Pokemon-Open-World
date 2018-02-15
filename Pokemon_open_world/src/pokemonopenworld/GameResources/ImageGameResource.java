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
import java.net.*;
import javax.swing.*;


/**
 *
 * @author
 */
public class ImageGameResource extends GameResource {
    private Image image;
    private final boolean fromAtlas;
    private final AtlasGameResource sourceAtlas;
    private final int atlasPos;

    public ImageGameResource(String name, URL path) throws MalformedURLException {
        super(name, path);
        image = null;
        fromAtlas = false;
        sourceAtlas = null;
        atlasPos = -1;
    }
    public ImageGameResource(String name, AtlasGameResource source, int atlasPos) throws MalformedURLException {
        super(name, null);
        image = null;
        fromAtlas = true;
        sourceAtlas = source;
        this.atlasPos = atlasPos;
    }
    
    @Override
    public boolean load(){
        if(fromAtlas){
            ImageIcon icon = new ImageIcon(path);
            image = icon.getImage();
            image = ImageTransparentBackgroundConverter.makeBackgroundTransparent(image);
        }else{
            if(!sourceAtlas.getEmpty()){
                
                //when the AtlasGameResource class is ready to use
            }
        }
        return !getEmpty();
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
        toReturn += "image game resource located ";
        if(fromAtlas)
            toReturn += "in atlas (" + sourceAtlas.toString() + ")";
        else
            toReturn += "on path" + path;
        toReturn += " and called \"" + name + "\" and ";
        if(!getEmpty())
            toReturn += "sized " + image.getWidth(null) + "x" + image.getHeight(null);
        else{
            toReturn += "empty";
        }
        return toReturn;
    }
}
