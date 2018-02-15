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
    
    private static final int RESOURCES_COUNT = 2;
    
    
    public static enum State{
        EMPTY,
        LOADING,
        READY
    }
    
        
    public ResourcePack() throws MalformedURLException{
        this(new URL("VanillaPack"));
    }
    public ResourcePack(URL path){
        name = path.getFile(); //TODO: packs should be named by their info.txt file
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
                toReturn += "loaded from " + getLoadingProgress() + "%";
                break;
            case READY:
                toReturn += "ready to use";
        } 
        return toReturn;
    }
    
    public int getLoadingProgress(){
        return loadingProgress;
    }
    
    public double getLoadingPercentage(){
        return RESOURCES_COUNT / loadingProgress * 100.0;
    }
    
    public void load(){
        
    }
}
