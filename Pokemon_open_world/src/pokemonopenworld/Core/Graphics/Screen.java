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
public abstract class Screen {
    protected static int width = 0;
    protected static int height = 0;
    
    public static void setSize(int newSize){
        width = newSize;
        height = newSize / 16 * 9;
    }
    
    public Screen(int size){
        width = size;
        height = size / 16 * 9;
    }
    
    public abstract void draw(Graphics graphics);
}
