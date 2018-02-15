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

/**
 *
 * @author
 */
public class AtlasGameResource extends GameResource {
    private Image atlasImage;
    private AtlasGameResourceExtractingInstruction[][] extractingInstructions;
    private Image[] result;
 
    public AtlasGameResource(String name,URL path) throws MalformedURLException {
        super(name, path);
    }
    @Override
    public boolean load(){
        return false;
    }
    
    @Override
    public boolean getEmpty(){
        return atlasImage == null;
    }
    
    
    public Image getResult(int position){
        return result[position];
    }
} 
