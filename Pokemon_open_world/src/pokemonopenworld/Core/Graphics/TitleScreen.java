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
    
    public TitleScreen(){
        super();
    }
    
    private int getAnimationProgress(){
        return (int)(Math.floorMod(Date.from(Instant.now()).getTime(), width));
    }
    
    @Override
    public void draw(Graphics graphics){
        int progress = getAnimationProgress();
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(0, 0, progress, height);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(progress, 0, width - progress, height);
    }
}
