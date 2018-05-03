/* 
 *                                                                          
 *   _____     _                                                         _   _ 
 *  |  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *  |   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *  |__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                         |_|
 *  03.05.2018
 */
package pokemonopenworld.Core;

/**
 * basic loading thread superclass for loading screens to have their stuff more organized
 */
public class LoadingThread extends Thread{
    protected float progress;
    
    public LoadingThread(){
        super();
        progress = 0f;
        setName("Anonymous loading thread. (!!!)");
    }
    
    float getProgress(){
        return progress;
    }
    
    @Override
    public void run(){
        //...
    }
}
