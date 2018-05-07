/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  20.03.2018
 */
package pokemonopenworld.Core;
import java.awt.*;
import javax.swing.*;
/**
 *
 */
public class CanvasRenderer extends Thread {
    private final Canvas canvas;
    private boolean active = false;
    
    public CanvasRenderer(Canvas canvas){
        super();
        setName("Renderer for the Canvas component");
        this.canvas = canvas;
    }
    
    public void deactivate(){
        active = false;
    }
    
    @Override
    public void run(){
        active = true;
        while(active)
            canvas.paint(canvas.getGraphics());
    }
}
