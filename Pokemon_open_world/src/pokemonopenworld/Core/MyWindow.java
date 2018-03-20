/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  07.02.2018
 */
package pokemonopenworld.Core;

import java.awt.*;
import javax.swing.*;
import pokemonopenworld.Core.Graphics.*;
/**
 *
 * @author 
 */
public class MyWindow {
    private final JFrame frame;
    private final MyCanvas canvas;
    private final MyCanvasRenderer renderer;
    
    
    public MyWindow(int width, int height){
        this(width, height, "Pokémon open world", null, null);
    }
    public MyWindow(int width, int height, String title){
        this(width, height, title, null, null);
    }
    public  MyWindow(int width, int height, String title, Image icon, Cursor cursor) {
        canvas = new MyCanvas();
        renderer = new MyCanvasRenderer(canvas);
        frame = new JFrame(title);
        
        canvas.setSize(width, height);
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        if(cursor != null)
            frame.setCursor(cursor);
        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        
        if(icon != null)
            frame.setIconImage(icon);
        
        frame.setVisible(true);
        
        renderer.start();
    }
     
    public void setVisible(boolean visible){
        if(visible == frame.isVisible())
            return;
        
        if(visible){
            frame.setVisible(visible);
            renderer.start();
        }   
        else{
            renderer.deactivate();
            frame.setVisible(visible);
        }
    }
    
    public void resize(Dimension size){
        resize(size.width, size.height);
    }
    public void resize(int width, int height){
        frame.setResizable(true);
        canvas.setSize(width, height);
        frame.pack();
        frame.setResizable(false);
    }
     
    //why did I put this in here ... ?
    public void render(){
       canvas.paint(canvas.getGraphics());
    }
     
    public void dispose(){
       frame.dispose();
    }
    
    public void setCursor(Cursor cursor){
        frame.setCursor(cursor);
    }

    public void setIconImage(Image icon){
        frame.setIconImage(icon);
    }
    
    public void setActiveScreen(Screen newActiveScreen){
        canvas.activeScreen = newActiveScreen;
    }
    
    public Screen getActiveScreen(){
        return canvas.activeScreen;
    }
}
