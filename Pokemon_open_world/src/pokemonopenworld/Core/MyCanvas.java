/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  07.02.2018
 * !!!invalid!!!
 */
package pokemonopenworld.Core;

import java.awt.*;
import pokemonopenworld.Core.Graphics.*;
/**
 *
 */
public class MyCanvas extends Canvas {
    public Screen activeScreen = null;
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(activeScreen != null)
            activeScreen.draw(g);
    }
}
