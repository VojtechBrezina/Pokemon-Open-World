/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  07.02.2018
 */
package pokemonopenworld;

import java.awt.*;
/**
 *
 * @author 
 */
public class MyCanvas extends Canvas {
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.drawString("CS", 50, 50);
    }
}
