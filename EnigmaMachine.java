import java.io.IOException;
import java.util.Scanner;

/**
 * EnigmaMachine class is the main pillar in the creation of the machine
 * Having the required methods to create and attach all components
 * in order to have a functional machine for encryption
 */

public class EnigmaMachine{
    private Plugboard plugBoard;
    private BasicRotor[] basicRotors;
    private Reflector reflector;

    /**
     * This is the constructor for this class
     * It attaches a Plugboard and 3 Rotors to the EnigmaMachine
     */

    public EnigmaMachine(){
        plugBoard = new Plugboard();
        basicRotors = new BasicRotor[3];

    }

    /**
     * The addPlug method is used to attach a plug to the Plugboard using two chars as parameters
     * The two parameters represent the first and the second end of the plug
     * Two letters that would be connected in the PlugBoard
     * @param end1
     * @param end2
     */

    public void addPlug(char end1, char end2){
        if(!plugBoard.addPlug(end1,end2)){
         //System.out.println("Sorry, you can't add this plug");
        }
    }

    /**
     * A really important method is clearPlugboard
     * It is essential to do it after each test because, if it's not used
     * the old configurations (from other tests) will still be present
     * thus, old connections from the Plugboard will be used to new tests
     * corrupting the output message
     */

    public void clearPlugboard(){
       plugBoard.clear();
    }

    /**
     * addRotor is an basic required method that adds a Rotor into a slot, thus attaching it to the Machine
     * ranging from 0 to 2
     * As parameters, it receives a Basic Rotor and the slot where it should be added
     * @param bRotor
     * @param slot
     */

    public void addRotor(BasicRotor bRotor, int slot){
       if(basicRotors[0] != bRotor || basicRotors[1] != bRotor || basicRotors[2] != bRotor){
           basicRotors[slot] = bRotor;
       }else{
           System.out.println("You can't add two identical rotors");
       }
    }

    /**
     * This getter returns the BasicRotor from a specific slot
     * @param slot
     * @return BasicRotor from specified slot
     */

    public BasicRotor getRotor(int slot){

        return basicRotors[slot];

    }

    /**
     * addReflector is another basic yet essential method that attaches a Reflector to the Enigma Machine
     * using a Reflector as a parameter
     * @param reflector
     */

    public void addReflector(Reflector reflector){
        this.reflector = reflector;
    }

    /**
     * getReflector is the getter that returns the Reflector attached to the Machine
     * @return Reflector
     */

    public Reflector getReflector(){
        return reflector;
    }

    /**
     * The setPosition method sets the initial position for a Basic Rotor from a specified slot
     * The method uses the slot variable to access the Rotor and set it's starting position
     * @param slot
     * @param position
     */

    public void setPosition(int slot, int position){
       basicRotors[slot].setPosition(position);
    }

    /**
     * The most important method is the encrypting one, encodeLetter
     * This method receives a char as a parameter representing a letter
     * After the conversion of the letter (using the ASCII table and substituting 65 because in our scope, letters are from 0 to 25)
     * Using the converted letter, we are going to encode it through the 3 Rotors, then through the Reflector and backwards through the Rotors again
     * For this, the method getRotor was used to get the letter through the Rotors on slots 0, 1, 2 then 2, 1, 0
     * and the method substitute was used to encrypt the letter, using the mapping of the Rotor
     * at the end, the rotor on the slot 0 is rotated using the rotate() method
     * The returned value is the conversion of the encrypted value (65 is added back to the number and it is converted to a char)
     * @param letter
     * @return encoded letter
     */

    public char encodeLetter(char letter){

        int asciiLetter;
        asciiLetter = ((int) plugBoard.substitute(letter)) - 65;

        asciiLetter = getRotor(0).substitute(asciiLetter);
        asciiLetter = getRotor(1).substitute(asciiLetter);
        asciiLetter = getRotor(2).substitute(asciiLetter);
        asciiLetter = reflector.substitute(asciiLetter);
        asciiLetter = getRotor(2).substituteBack(asciiLetter);
        asciiLetter = getRotor(1).substituteBack(asciiLetter);
        asciiLetter = getRotor(0).substituteBack(asciiLetter);
        getRotor(0).rotate();
        return plugBoard.substitute((char)(asciiLetter+65));

    }


    /**
     * The start() method contains the first 3 tests for the Enigma machine
     * It sets up the elements (adds the Plugs, Rotors and Reflectors)
     * And manually outputs the encoded version of each input letter (for the first 2 tests)
     * Or outputs the encrypted version of the text introduced in the input.txt file (for the third test)
     */

    public void start(){
       //test1();
      // test2();
       //test3();
    }

    /**
     * The first test from the file
     * The specified plugs, Rotors and Reflectors are being set for the test
     */

    private void test1(){
        //Test 1:
        clearPlugboard();

        BasicRotor firstRotor = new BasicRotor("I");
        BasicRotor secondRotor = new BasicRotor("II");
        BasicRotor thirdRotor = new BasicRotor("III");

        firstRotor.setPosition(6);
        secondRotor.setPosition(12);
        thirdRotor.setPosition(5);

        addRotor(firstRotor,0);
        addRotor(secondRotor,1);
        addRotor(thirdRotor,2);

        Reflector reflector = new Reflector("ReflectorI");
        addReflector(reflector);

        addPlug('A','M');
        addPlug('G','L');
        addPlug('E','T');

        System.out.print(encodeLetter('G'));
        System.out.print(encodeLetter('F'));
        System.out.print(encodeLetter('W'));
        System.out.print(encodeLetter('I'));
        System.out.print(encodeLetter('Q'));
        System.out.print(encodeLetter('H'));

        System.out.println();


    }

    /**
     * The second test from the file
     * The specified plugs, Rotors and Reflectors are set for the test
     */

    private void test2(){

        //Test 2:

        /**
         * Very important asspect is to clear the PlugBoard after each test
         * So that the old Plugs don't interfere with the encoding process
         */

        clearPlugboard();

        BasicRotor firstRotor2 = new BasicRotor("IV");
        BasicRotor secondRotor2 = new BasicRotor("V");
        BasicRotor thirdRotor2 = new BasicRotor("II");

        firstRotor2.setPosition(23);
        secondRotor2.setPosition(4);
        thirdRotor2.setPosition(9);

        addRotor(firstRotor2,0);
        addRotor(secondRotor2,1);
        addRotor(thirdRotor2,2);

        Reflector reflector2 = new Reflector("ReflectorII");
        addReflector(reflector2);


        addPlug('B','C');
        addPlug('R','I');
        addPlug('S','M');
        addPlug('A','F');

        System.out.print(encodeLetter('G'));
        System.out.print(encodeLetter('A'));
        System.out.print(encodeLetter('C'));
        System.out.print(encodeLetter('I'));
        System.out.print(encodeLetter('G'));


    }

    /**
     * The third test from the file
     * The specified plugs, Rotors and Reflectors are set for the test
     */

    private void test3(){
        //Test 3:
        clearPlugboard();

        addPlug('Q','F');

        /**
         * For this test, the Turnover Rotors were used
         * They are initialized from the end to the beginning, because the last Turnover Rotor doesn't have a next Rotor to rotate
         * Thus, when creating the second Rotor, the already created 3rd Rotor can be used as the "next Rotor" and later on rotated
         */

        TurnoverRotor turnRot3 = new TurnoverRotor("III", null );
        TurnoverRotor turnRot2 = new TurnoverRotor("II", turnRot3 );
        TurnoverRotor turnRot1 = new TurnoverRotor("I", turnRot2 );

        addRotor(turnRot1,0);
        addRotor(turnRot2,1);
        addRotor(turnRot3,2);

        setPosition(0,23);
        setPosition(1,11);
        setPosition(2,7);

        Reflector reflector3 = new Reflector("ReflectorI");
        addReflector(reflector3);

        /**
         * This section is used in order to convert the input from a file
         * An additional extension was used so that the text entered was converted
         * So that no errors will occur
         */

        Convert format = new Convert();

        EnigmaFile enigma1 = new EnigmaFile();
        String line;
        try {
            line = enigma1.readFromFile();
            line=format.formatInput(line);
            StringBuffer newLine = new StringBuffer();
            /**
             * This for loop takes each entry from the String and encodes it
             * Then appends the letter to the output String (adds the letter to the String that will be printed)
             * charAt was used to take a char from a specified position in a String
             * .append was used to add the letters encoded to the string
             */
            for(int i =0; i< line.length();i++){
                char caract = line.charAt(i);
                newLine.append(encodeLetter(caract));

            }

            enigma1.writeToFile(newLine.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * the Main function contains all the tests done with the Enigma Machine
     * In order to test a specific test, you have to uncomment the test
     * For the first three test, uncomment the test you want to make from both the main and the start methods
     * @param args
     */
    public static void main(String args[]){

        System.out.println("Welcome to the Enigma Machine! In order to continue and test it, please uncomment one of the test ahead.");
        System.out.println();

    /**
     * Uncomment this if you want to test one(or all) of the first 3 tests
     * Go to start method and uncomment what test you want to execute
     * Then run the code
     */

//        EnigmaMachine enigmMach= new EnigmaMachine();
//        enigmMach.start();

    /**
    * This part is for the Hrness tests, the challenges
     * a new Enigma Machine, Enigma File and Bombe instances must be created
     * Execute one test at a time
    */


        EnigmaMachine enigMach = new EnigmaMachine();
        EnigmaFile enigFile = new EnigmaFile();
        Bombe bombe = new Bombe(enigMach,enigFile);

//        enigMach.clearPlugboard();
//        bombe.testHarness1();

//        enigMach.clearPlugboard();
//        bombe.testHarness2();

//        enigMach.clearPlugboard();
//        bombe.testHarness3();


        /**
         * This part is an extension for a User
         * Uncomment this to build your own Enigma Machine
         * Customize it
         * Then add the input message and see the encoding process going on live
         */

//        UserReader u = new UserReader();
//        u.intro();
//        u.setUp();
//        u.input();


    }


}
