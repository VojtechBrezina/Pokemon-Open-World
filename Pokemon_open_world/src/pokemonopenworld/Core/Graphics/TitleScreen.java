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
import java.time.Instant;
import java.util.Date;
/**
 *
 * @author
 */
public class TitleScreen extends Screen {
    private long lastAnimationStart;
    
    public TitleScreen(){
        super();
        resetAnimation();
    }
    
    private void resetAnimation(){
        lastAnimationStart = Date.from(Instant.now()).getTime();
    }
    
    private int getAnimationProgress(){
        return (int)(Date.from(Instant.now()).getTime() - lastAnimationStart);
    }
    
    @Override
    public void draw(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.clearRect(0, 0, width, height);
    }
}
