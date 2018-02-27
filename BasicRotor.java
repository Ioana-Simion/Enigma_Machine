/**
 * This class will help build and set up the configuration for the Basic Rotors
 * The Basic Rotors are one of the main parts in the Enigma Machine and, using their mapping, will help encrypt the message
 */
public class BasicRotor extends Rotor {

    private int[] mapping1 = new int[26];
    private int[]reversedMapping =new int[26];
    int position;

    /**
     * This is the constructor for this class, that uses the variables from Rotor and then Initialises the Rotor
     * According to the name received
     * @param name
     */

    public BasicRotor(String name){
        super(name);
        initialise(name);
    }

    /**
     * The Substitute method will first substitute from the param position, the Position on witch the Rotor is at
     * For this, we must check it the resulted value is lower than 0 (and if so, add 26) so that the position will always be a valid number( between 0 and 25)
     * In the mapped variable we save the sum between the mapped version of the position and the position of the Rotor
     * Again, we must check if the variable has exceeded the boundaries
     * @param position
     * @return mapped , being the value of the letter after passing through the Rotor
     */
    
    public int substitute(int position){

       position -= getPosition();

       if (position < 0){
           position += 26;
       }

       int mapped = mapping1[position] + getPosition();

       if (mapped > 25){
           mapped -= 26;
       }

      return mapped;
    }

    /**
     * substituteBack is doing the same process but in reversed, so that, after passing through the Reflector
     * the letter goes backwards through the Rotors, being encrypted even further
     * @param position
     * @return
     */

    public int substituteBack(int position){

        int[] reversedMapping = new int[26];

        for(int i=0;i<26;i++){
            reversedMapping[mapping1[i]]= i;
        }

        position -= getPosition();

        if (position < 0){
            position += 26;
        }

        int mapped = reversedMapping[position] + getPosition();

        if (mapped > 25){
            mapped -= 26;
        }

        return mapped;

    }

    /**
     * the initialise method uses a Swich case to swich between the various types of mapping
     * giving the corresponding one to a Rotor, according to its name
     * @param name that can be seen as a type too
     */

    void initialise(String name) {
     this.name= name;
     switchCase(name);

    }

    /**
     * The rotate function checks if the Rotor has reached the last position (25)
     * If not, it's position will only be increased by one
     * If it's true, the position will be reinitialised to 0
     * This method will help make a text containing more copies of a letter output something different for each one
     */

    public void rotate(){
        if(getPosition() != 25){
            setPosition(getPosition() + 1);
        }else {
            setPosition(0);
        }
    }

    /**
     * This switchCase only switches between the mappings
     * @param name
     */

    public void switchCase(String name){
        switch(name){
            case "I":
                this.mapping1 = new int[] { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
                break;
            case "II":
                mapping1 = new int[] { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
                break;
            case "III":
                mapping1 = new int[] { 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
                break;
            case "IV":
                mapping1 = new int[] {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
                break;
            case "V":
                mapping1 = new int[] { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
                break;
        }

    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
