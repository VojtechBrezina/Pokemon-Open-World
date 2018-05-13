/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  15.02.2018
 */
package pokemonopenworld.Core;

import java.awt.*;
import java.net.*;
import pokemonopenworld.GameResources.*;
import pokemonopenworld.Core.Graphics.*;

/**
 *
 * @author
 */
public class Game {
    private MyWindow window;
    private ResourcePack activePack;
    private ResourcePackLoader activePackLoader;
    
    @SuppressWarnings("empty-statement")
    public Game() throws MalformedURLException{
        activePack = new ResourcePack(getClass().getResource("../VanillaPack/"));
        activePackLoader = new ResourcePackLoader(activePack);
        
        
        //TODO:
    }
}
