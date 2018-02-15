/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  07.02.2018
 */
package Core;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author 
 */
public class MyWindow {
    private final JFrame frame;
    private final MyCanvas canvas;
    
     MyWindow(int width, int height, String title, Image icon, Cursor cursor) {
        canvas = new MyCanvas();
        frame = new JFrame(title);
        
        canvas.setSize(width, height);
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setCursor(cursor);
        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        
        frame.setIconImage(icon);
        
        frame.setVisible(true);
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
     
     public void render(){
         canvas.paint(canvas.getGraphics());
     }
     
     public void dispose(){
         frame.dispose();
     }

}
