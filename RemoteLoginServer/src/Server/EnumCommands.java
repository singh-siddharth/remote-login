/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

public enum EnumCommands {
    PRESS_MOUSE(-1),
    RELEASE_MOUSE(-2),
    PRESS_KEY(-3),
    RELEASE_KEY(-4),
    MOVE_MOUSE(-5);

    private int code;

    EnumCommands(int code){
        this.code = code;
    }
   public int getCode(){
        return code;
    }
}
