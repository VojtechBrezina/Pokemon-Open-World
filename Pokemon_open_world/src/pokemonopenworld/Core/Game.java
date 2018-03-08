/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  15.02.2018
 */
package pokemonopenworld.Core;

import java.net.MalformedURLException;
import pokemonopenworld.GameResources.*;

/**
 *
 * @author
 */
public class Game {
    private MyWindow window;
    private ResourcePack activePack;
    private ResourcePackLoader activePackLoader;
    
    public Game() throws MalformedURLException{
        window = new MyWindow(640, 360);
        activePack = new ResourcePack();
        
        while(activePack.getLoadingPercentage() != 100){
            
        }
        //TODO:
    }
}
