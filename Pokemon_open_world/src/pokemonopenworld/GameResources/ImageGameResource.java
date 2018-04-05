/* 
 *                                                                          
 *   _____     _                                                         _   _ 
 *  |  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *  |   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *  |__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                         |_|
 *  10.02.2018
 */
package pokemonopenworld.GameResources;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import javax.imageio.*;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author
 */
public class ImageGameResource extends GameResource {
    private Image image;
    private Image[] frames;
    private int framesCount;
    private int framesPerSecond;
    private URL imagePath;

    public ImageGameResource(String name, URL path) throws MalformedURLException {
        super(name, path);
        image = null;
        imagePath = null;
        framesCount = -1;
        framesPerSecond = -1;
    }
   
    @Override
    public boolean load() throws MalformedURLException{   
        try{
            if(imagePath == null || framesCount < 0 || framesPerSecond < 0){//incorrect parameers, need to reload them from the *.poi(xml) file
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path.toString());
                Element rootElement = document.getDocumentElement(); //<imageResource>
                
                imagePath = new URL(path, rootElement.getAttribute("fileName"));
                framesCount = Integer.parseInt(rootElement.getAttribute("animationFramesCount"));
                framesCount = Integer.parseInt(rootElement.getAttribute("animationFPS"));
            }
            image = ImageTransparentBackgroundConverter.makeBackgroundTransparent(ImageIO.read(imagePath));
        }catch(IOException | NumberFormatException ionfe){
            //broken resource !!MUST NOT OCCUR AT VANILLA LEVEL!!
            System.out.println("The resource is broken and must be replaced with default pack.");
            
            //to make sure, that the pack loader notices something being wrong
            image = null;
            frames = null;
            imagePath = null;
        } catch (ParserConfigurationException pce) {
            //hope, that isn't the case :)
            System.out.println("Badly configurated parser ?!?");
        }catch (SAXException saxe) {
            //nor this one ...
            System.out.println("SAX exception ...");
        }
        

           
        return !getEmpty();
    }
    
    public void setImage(Image image){
        this.image = image;
    }
    
    public Image getImage(){
        return image;
    }
    
    @Override
    public boolean getEmpty(){
        return image == null || image.getHeight(null) == -1;
    }
    
    @Override
    public String toString(){
        String toReturn = "";
        toReturn += "image game resource located on path \"" + imagePath;
        toReturn += "\" and called \"" + name + "\" and ";
        if(!getEmpty())
            toReturn += "sized " + image.getWidth(null) + "x" + image.getHeight(null);
        else{
            toReturn += "empty";
        }
        return toReturn;
    }
}
