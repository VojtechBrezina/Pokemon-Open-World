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

import org.w3c.dom.Document;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.imageio.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.*;



/**
 *
 * @author
 */
public class ImageGameResource extends GameResource {
    private BufferedImage image;
    private BufferedImage[] frames;
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
            int imageWidth;
            int imageHeight;
            int frameWidth;
            
            if(imagePath == null || framesCount < 0 || framesPerSecond < 0){//incorrect parameers, need to reload them from the *.poi(xml) file
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path.toString());
                Element rootElement = document.getDocumentElement(); //<imageResource>
                
                if(!rootElement.getNodeName().equals("imageResource")){
                    System.out.print(rootElement.getNodeName());
                }
                
                imagePath = new URL(path, rootElement.getAttribute("filePath"));
                framesCount = Integer.parseInt(rootElement.getAttribute("animationFramesCount"));
                framesPerSecond = Integer.parseInt(rootElement.getAttribute("animationFPS"));
            }
            
            image = (BufferedImage)ImageTransparentBackgroundConverter.makeBackgroundTransparent(ImageIO.read(imagePath));
            
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
            frameWidth = imageWidth / framesCount;
            
            for(int i = 0; i < framesCount; i++){
                frames[i] = image.getSubimage(i * frameWidth, 0, frameWidth, imageHeight);
            }
            
            frames = new BufferedImage[framesCount];
        } catch (ParserConfigurationException pce) {
            //hope, that isn't the case :)
            System.out.println("Badly configurated parser ?!?");
        }catch (SAXException saxe) {
            //nor this one ...
            System.out.println("SAX exception ...(broken resource file)");
        }catch(Exception e){
            //broken resource !!MUST NOT OCCUR AT VANILLA LEVEL!!
            System.out.println("File will be replaced because it's missing or the file contains broken data.");
            //to make sure, that the pack loader notices something being wrong
            image = null;
            frames = null;
            imagePath = null;
        }
        

           
        return !getEmpty();
    }
    
    public void setImage(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage getImage(){
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
