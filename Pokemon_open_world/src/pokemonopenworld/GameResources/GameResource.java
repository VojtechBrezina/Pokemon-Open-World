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

import java.net.*;

/**
 *
 * @author
 */
public abstract class GameResource {
    protected String name;
    protected URL path;
    
    public GameResource(String name, URL path) throws MalformedURLException{
        this.name = name;
        this.path = path;
    }
    
    public String getName(){
        return name;
    }
    
    public abstract boolean getEmpty();
    public abstract boolean load() throws MalformedURLException;
}
