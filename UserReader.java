import java.io.IOException;
import java.util.Scanner;

public class UserReader {
    String answer;
    Scanner scan = new Scanner(System.in);
    public void intro(){
        System.out.println("Welcome to the Enigma machine!");
        System.out.println("In order to start, let's first set up the machine:");
    }
    EnigmaFile enigFile= new EnigmaFile();
    EnigmaMachine enigMach = new EnigmaMachine();

    char end1, end2;
    String e1,e2;
    public void setUp() {
        System.out.println("Do you want to add a plug?");
        System.out.println("Type 'yes' or 'no' . . .");
        answer = scan.next();
        while(answer.equals("yes")) {
            System.out.println("Please introduce the first end of the plug:");
            e1 = scan.next();
            end1 = e1.charAt(0);

            System.out.println("Please introduce the second end of the plug:");

            e2 = scan.next();
            end2 = e2.charAt(0);
            enigMach.addPlug(end1,end2);
            System.out.println("Do you want to add another plug?");
            System.out.println("Type 'yes' or 'no' . . .");
            answer = scan.next();
        }
        System.out.println("Now you have to add the rotors.");
        String name;
        int pos;
            System.out.println("Remember that the 3 rotors should have different types.");
            System.out.println("Please specify the rotor type for the first rotor:");
            System.out.println("Use roman numbers. Pick between: I, II, III, IV and V . . .");
            name = scan.next();
            BasicRotor rotor1 = new BasicRotor(name);
            System.out.println("Please specify the rotor type for the second rotor:");
            System.out.println("Use roman numbers. Pick between: I, II, III, IV and V . . .");
            name = scan.next();
            BasicRotor rotor2 = new BasicRotor(name);
            System.out.println("Please specify the rotor type for the third rotor:");
            System.out.println("Use roman numbers. Pick between: I, II, III, IV and V . . .");
            name = scan.next();
            BasicRotor rotor3 = new BasicRotor(name);
            System.out.println("Now you have to set the initial positions");
            System.out.println("Please specify a position between 0 and 25");
            System.out.println("Introduce the position for the first rotor:");
            pos= scan.nextInt();
            while(pos<0 || pos >25){
                System.out.println("Please specify a position between 0 and 25");
                pos= scan.nextInt();
            }
            rotor1.setPosition(pos);
            System.out.println("Introduce the position for the second rotor:");
            System.out.println("Please specify a position between 0 and 25");
            pos= scan.nextInt();
             while(pos<0 || pos >25){
                 System.out.println("Please specify a position between 0 and 25");
                 pos= scan.nextInt();
             }
            rotor2.setPosition(pos);
            System.out.println("Introduce the position for the third rotor:");
            System.out.println("Please specify a position between 0 and 25");
            pos= scan.nextInt();
            while(pos<0 || pos >25){
                System.out.println("Please specify a position between 0 and 25");
                pos= scan.nextInt();
            }
            rotor3.setPosition(pos);

            enigMach.addRotor(rotor1,0);
            enigMach.addRotor(rotor2,1);
            enigMach.addRotor(rotor3,2);

        System.out.println("Now, you just have to add a reflector");
        System.out.println("Reflectors have 2 types: either ReflectorI or ReflectorII");
        System.out.println("Input 1 for ReflectorI or 2 for ReflectorII");
        int input;
        input=scan.nextInt();
        while(input!= 1 && input!= 2){
            System.out.println("Input 1 for ReflectorI or 2 for ReflectorII");
            input=scan.nextInt();
        }
        if(input == 1){
            Reflector reflector = new Reflector("ReflectorI");
            enigMach.addReflector(reflector);
        }else {
            Reflector reflector = new Reflector("ReflectorII");
            enigMach.addReflector(reflector);
        }
        System.out.println("Now you have your Enigma Machine all set up");


    }
    public void input(){
        System.out.println("Now introduce the text you want to encode");
        System.out.println("In this version you will see a live encoding process");
        char caract;
        String input;
        String output;
        System.out.println("When you finished typing your message, type 'end' ");
        System.out.println("Please introduce capital letters ranging from A to Z");
        input=scan.next();
        StringBuilder builder = new StringBuilder();
        while(!input.equals("end")) {
            caract = input.charAt(0);
            caract= enigMach.encodeLetter(caract);
            System.out.println(caract);
            builder.append(caract);
            System.out.println("Introduce the next letter or 'end' ");
            System.out.println("Please introduce capital letters ranging from A to Z");
            input=scan.next();
        }
        output=builder.toString();
        System.out.println("The final output is: "+ output);
    }


}
