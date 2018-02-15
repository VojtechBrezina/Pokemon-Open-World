/* 
 *                                                                          
 *   _____     _                                                         _   _ 
 *  |  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *  |   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *  |__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                         |_|
 *  13.02.2018
 */
package pokemonopenworld.GameResources;

/**
 *
 * @author
 */
public class AtlasGameResourceExtractingInstruction {
    public int rotate;
    public int sourceX;
    public int sourceY;
    public int sourceWidth;
    public int sourceHeight;
    public int destinatonX;
    public int destinationY;
    public int destinationWidth;
    public int destinationHeight;
    
    //will be added when needed
    public AtlasGameResourceExtractingInstruction(){
        this(0, 0, 0, -1, -1, 0, 0, -1, -1);
    }
    public AtlasGameResourceExtractingInstruction(int rotate){
        this(rotate, 0, 0, -1, -1, 0, 0, -1, -1);
    }
    public AtlasGameResourceExtractingInstruction(int rotate, int sourceX, int sourceY){
        this(rotate, sourceX, sourceY, -1, -1, 0, 0, -1, -1);
    }
    public AtlasGameResourceExtractingInstruction(int sourceX, int sourceY){
        this(0, sourceX, sourceY, -1, -1, 0, 0, -1, -1);
    }
    public AtlasGameResourceExtractingInstruction(int rotate, int sourceX, int sourceY, int sourceWidth, int sourceHeight, int destinatonX, int destinationY, int destinationWidth, int destinationHeight){
        this.rotate = rotate;
        this.sourceX = sourceX;
        this.sourceY = sourceY;
        this.sourceWidth = sourceWidth;
        this.sourceHeight = sourceHeight;
        this.destinatonX = destinatonX;
        this.destinationY = destinationY;
        this.destinationWidth = destinationWidth;
        this.destinationHeight = destinationHeight;
    }
}
