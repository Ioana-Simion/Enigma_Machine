import java.util.Objects;

/**
 * The Plug class is assigned with the purpose of creating connections in the PlugBoard
 * And checking if some connections are possible to make
 */

public class Plug {
    private char end1, end2;

    /**
     * the Constructor sets the ends of the plug (characters)
     * @param end1
     * @param end2
     */

    public Plug(char end1, char end2){
         this.end1 = end1;
         this.end2 = end2;
    }

    /**
     * the Getters and Setters for the PRIVATE ends
     */

    public char getEnd1(){
        return end1;
    }
    public char getEnd2(){
        return end2;
    }
    public void setEnd1(char end1){
        this.end1 = end1;
    }
    public void setEnd2(char end2){
        this.end1 = end2;
    }

    /**
     * Checks if the letter introduced is mapped somewhere in the PlugBoard
     * Basically, if there is a PLUG connected between the parameter letter and another end
     * If a plug is find, the output is the other end of the Plug connection
     * If not, the initial letter is returned
     * @param letterIn
     * @return the encoded letter
     */

    public char encode(char letterIn){
        if(letterIn == getEnd1()){
           letterIn = getEnd2();
        } else if(letterIn == getEnd2()){
            letterIn = getEnd1();
            }

        return letterIn;
    }

    /**
     * The clashesWith method is used when a new plug is added
     * If one of the ends of the new plug is already connected in the Plugboard, the return will be true
     * Meaning that indeed, that plug Clashes with another one
     * @param plugin
     * @return
     */
    public boolean clashesWith(Plug plugin){
        if(getEnd1() == plugin.getEnd1() || getEnd1() == plugin.getEnd2() || getEnd2() == plugin.getEnd2() || getEnd2() == plugin.getEnd1()){
            return true;
             }else{
                return false;
              }
    }

}
