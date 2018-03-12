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

/**
 *
 * @author
 */
public class Game {
    private final MyWindow window;
    private final ResourcePack activePack;
    private final ResourcePackLoader activePackLoader;
    
    public Game() throws MalformedURLException{
        activePack = new ResourcePack(getClass().getResource("../VanillaPack/"));
        
        activePackLoader = new ResourcePackLoader(activePack);
        
        activePackLoader.start();
        
        while(activePack.getLoadingProgress() < ResourcePack.CURSOR_IMAGE_RESOURCE_ID + 1)
            ;
        window = new MyWindow(640, 360, "Pokémon open world", ((ImageGameResource)activePack.getResource(ResourcePack.ICON_RESOURCE_ID)).getImage(),
        Toolkit.getDefaultToolkit().createCustomCursor(((ImageGameResource)activePack.getResource(ResourcePack.CURSOR_IMAGE_RESOURCE_ID)).getImage(), new Point(0, 0), "Pokebal cursor"));
        while(activePack.getState() != ResourcePack.State.READY)
            ;
        
        
        //TODO:
    }
}
