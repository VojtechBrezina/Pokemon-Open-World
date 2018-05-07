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
public class MyWindow extends JFrame{
    private final Canvas canvas;
    private final CanvasRenderer renderer;
    
    
    public MyWindow(int width, int height){
        this(width, height, "Pokémon open world", null, null);
    }
    public MyWindow(int width, int height, String title){
        this(width, height, title, null, null);
    }
    public  MyWindow(int width, int height, String title, Image icon, Cursor cursor) {
        super(title);
        
        canvas = new Canvas();
        renderer = new CanvasRenderer(canvas);
        
        
        canvas.setSize(width, height);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        if(cursor != null)
            setCursor(cursor);
        add(canvas);
        pack();
        setResizable(false);
        
        if(icon != null)
            setIconImage(icon);
        
        setVisible(true);
        
        renderer.start();
    }
     
    @Override
    public void setVisible(boolean visible){
        super.setVisible(visible);
        
        if(visible == isVisible())
            return;
        
        if(visible){
            renderer.start();
        }   
        else{
            renderer.deactivate();
        }
    }
    
    @Override
    public void resize(Dimension size){
        resize(size.width, size.height);
    }
    @Override
    public void resize(int width, int height){
        setResizable(true);
        canvas.setSize(width, height);
        pack();
        setResizable(false);
    }
     
    //why did I put this in here ... ?
    public void render(){
       canvas.paint(canvas.getGraphics());
    }

    
    /*public void setActiveScreen(Screen newActiveScreen){
        canvas.activeScreen = newActiveScreen;
    }
    
    public Screen getActiveScreen(){
        return canvas.activeScreen;
    }*/
}
