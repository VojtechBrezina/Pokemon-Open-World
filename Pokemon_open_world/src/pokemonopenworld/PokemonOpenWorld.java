/*                                                                          
 * _____     _                                                         _   _ 
 *|  _  |___| |_ ___ _____ ___ ___    ___ ___ ___ ___    _ _ _ ___ ___| |_| |
 *|   __| . | '_| -_|     | . |   |  | . | . | -_|   |  | | | | . |  _| | . |
 *|__|  |___|_,_|___|_|_|_|___|_|_|  |___|  _|___|_|_|  |_____|___|_| |_|___|
 *                                       |_|
 *  07.02.2018
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonopenworld;

import java.net.MalformedURLException;
import java.util.Scanner;
import pokemonopenworld.gameresources.*;

/**
 *
 * @author 
 */
public class PokemonOpenWorld {
    
    private static MyWindow window;
    private static Scanner scanner;
    private static boolean ended = false;
    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException{
        scanner = new Scanner(System.in);
        //window = new MyWindow(640, 360, "Pokemon open world");
        
        ResourcePack activePack = new ResourcePack();
        
        
        while(!ended){
            if(scanner.hasNextLine()){
                command();
            }else{
                //window.render();
            }
        }
    }
    
    private static void command(){
        String cmd = scanner.nextLine();
        command(cmd);
    }
    private static void command(String cmd){
        switch(cmd){
            case "resize":
                window.resize(scanner.nextInt(), scanner.nextInt());
                scanner.nextLine();
                break;
            case "quit":
                quit();
                break;
            default:
                System.out.println("?");
                break;
        }
    }
    
    private static void quit(){
        //window.dispose();
        ended = true;
    }
    
}
