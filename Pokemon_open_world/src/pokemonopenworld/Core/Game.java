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
import java.util.logging.Level;
import java.util.logging.Logger;
import pokemonopenworld.GameResources.*;
import pokemonopenworld.Core.Graphics.*;

/**
 *
 * @author
 */
public class Game {
    private final MyWindow window;
    private final ResourcePack activePack;
    private final ResourcePackLoader activePackLoader;
    
    @SuppressWarnings("empty-statement")
    public Game() throws MalformedURLException{
        activePack = new ResourcePack(getClass().getResource("../VanillaPack/"));
        
        activePackLoader = new ResourcePackLoader(activePack);
        
        activePackLoader.start();
        
        while(activePack.getLoadingProgress() < ResourcePack.CURSOR_IMAGE_RESOURCE_ID + 1)
            ;
        window = new MyWindow(640, 360, "Pokémon open world", ((ImageGameResource)activePack.getResource(ResourcePack.ICON_IMAGE_RESOURCE_ID)).getImage(),
        Toolkit.getDefaultToolkit().createCustomCursor(((ImageGameResource)activePack.getResource(ResourcePack.CURSOR_IMAGE_RESOURCE_ID)).getImage(), new Point(0, 0), "Pokebal cursor"));
        Screen.setSize(640);
        
        while(activePack.getLoadingProgress() < ResourcePack.LOADING_BACKGROUND_IMAGE_RESOURCE_ID + 1)
            ;
        window.setActiveScreen(new BasicLoadingScreen("", ((ImageGameResource)activePack.getResource(ResourcePack.LOADING_BACKGROUND_IMAGE_RESOURCE_ID)).getImage()));
        
        while(activePack.getState() != ResourcePack.State.READY)
            ;
        window.setActiveScreen(new TitleScreen());
        
        //TODO:
    }
}
