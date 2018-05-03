/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  14.03.2018
 */
package pokemonopenworld.Core.Graphics;

import java.awt.*;

/**
 *
 * @author
 */
public class BasicLoadingScreen extends Screen{
    private String stateText;
    private Image background;
    
    public BasicLoadingScreen(String stateText, Image background){
        super();
        this.stateText = stateText;
        this.background = background;
    }
    
    @Override
    public void draw(Graphics graphics){
        graphics.drawImage(background, 0, 0, width, height, null);
    }
}
