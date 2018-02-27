import java.util.ArrayList;

/**
 * The Reflector class extends the Rotor
 * Here, a Reflector is being set up, being the element that reflects the encoded letter back through the Basic Rotors
 */

public class Reflector extends Rotor {

    private int[] mapping1;

    /**
     * the constructor sets the mapping for the Reflector
     * @param name
     */
    public Reflector(String name){
        super(name);
        mapping1 = new int[26];
        initialise(name);
    }

    /**
     * using the parameter Name, the initialise method swiches between the two possible mappings
     * @param name
     */

    public void  initialise (String name){
     if(name.equals("ReflectorI")){
         mapping1 = new int[]{24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
     }else if(name.equals("ReflectorII")){
         mapping1 = new int[]{ 5, 21, 15, 9, 8, 0, 14, 24, 4, 3, 17, 25, 23, 22, 6, 2, 19, 10, 20, 16, 18, 1, 13, 12, 7, 11 };
     }
    }

    /**
     * the Substitute method encrypts the letter using the Reflector's mapping
     * @param position
     * @return
     */
   public int substitute(int position){
    return mapping1[position];
   }
}
