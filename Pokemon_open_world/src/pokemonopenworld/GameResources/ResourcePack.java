/*                                                                           
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  08.02.2018
 */
package pokemonopenworld.GameResources;

import java.net.*;

/**
 *
 * @author 
 */
public class ResourcePack {
    private final String name;
    private final URL path;
    private State state;
    private int loadingProgress;
    private GameResource[] resources;
    
    private static final int RESOURCES_COUNT = 4;
    
    public static final int MISSING_BITMAP_IMAGE_RESOURCE_ID = 0;
    public static final int ICON_IMAGE_RESOURCE_ID = 1;
    public static final int CURSOR_IMAGE_RESOURCE_ID = 2;
    public static final int LOADING_BACKGROUND_IMAGE_RESOURCE_ID = 3;
    
    public static enum State{
        EMPTY,
        LOADING,
        READY
    }
    
        
    public ResourcePack() throws MalformedURLException{
        this(new URL("VanillaPack"));//Hardly broken, don't even know, what was I thinking !!!
    }
    public ResourcePack(URL path){
        name = path.toString(); //TODO: packs should be named by their info.txt file
        this.path = path;
        state = State.EMPTY;
        loadingProgress = 0;
        resources = new GameResource[RESOURCES_COUNT];
    }
    
    @Override
    public String toString(){
        String toReturn = "resource pack named \"" + name + "\" and ";
        switch(state){
            case EMPTY:
                toReturn += "empty";
                break;
            case LOADING:
                toReturn += "loaded from " + getLoadingPercentage() + "%";
                break;
            case READY:
                toReturn += "ready to use";
        } 
        return toReturn;
    }
    
    public GameResource getResource(int id){
        return resources[id];
    }
    
    public int getLoadingProgress(){
        return loadingProgress;
    }
    
    public double getLoadingPercentage(){
        return 100.0 * loadingProgress  / RESOURCES_COUNT;
    }
    
    public State getState(){
        return state;
    }
    
    @SuppressWarnings("empty-statement")
    public void load() throws MalformedURLException{
        state = State.LOADING;
        
        System.out.println("Loading resources...");
        
        resources = new GameResource[]{
            new ImageGameResource("Missing bitmap", new URL(path, "img/wip.PNG")),
            new ImageGameResource("Icon image", new URL(path, "img/ikona.png")),
            new ImageGameResource("Cursor image", new URL(path, "img/kurzor.png")),
            new ImageGameResource("Loading screen background", new URL(path, "img/load_n.PNG"))
        };
        
        loadingProgress = 0;
        for(int i = 0; i < RESOURCES_COUNT; i++){
            while(!resources[loadingProgress].load())
                ;
            loadingProgress++;
            System.out.print("*");
            //System.out.println(resources[loadingProgress - 1].toString());
        }
        
        System.out.println("\nDone!");
        
        state = State.READY;
    }
}
