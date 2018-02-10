/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  08.02.2018
 */
package pokemonopenworld;

/**
 *
 * @author 
 */
public class ResourcePack {
    private final String name;
    private final String path;
    private State state;
    private int loadingProgress;
    
    private static final int RESOURCES_COUNT = 2;
    
    
    public static enum State{
        EMPTY,
        LOADING,
        READY
    }
    
    
    private void init(){
        state = State.EMPTY;
        loadingProgress = 0;
    }
    
        
    public ResourcePack(){
        name = "Vanilla";
        path = "";
        init();
    }
    public ResourcePack(String path){
        name = path.substring(path.lastIndexOf("/")); //TODO: packs should be named by their info.txt file
        this.path = path;
        init();
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
    
    public double getLoadingProgress(){
            return RESOURCES_COUNT / loadingProgress * 100.0;
    }
}
