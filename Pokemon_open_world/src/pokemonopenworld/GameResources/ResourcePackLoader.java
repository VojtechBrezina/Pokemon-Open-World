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

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class ResourcePackLoader extends Thread {
    private final ResourcePack pack;
    
    
    public ResourcePackLoader(ResourcePack pack){
        this.pack = pack;
    }
    
    
    @Override
    public void run(){
        try {
            pack.load();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ResourcePackLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
