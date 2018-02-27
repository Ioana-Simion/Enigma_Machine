import java.io.IOException;

public class Bombe {

    EnigmaMachine enigMach = new EnigmaMachine();
    EnigmaFile enigFile = new EnigmaFile();
    String line;
    String answer="ANSWER";
    String daisy="DAISY";
    Convert format = new Convert();

    public Bombe(EnigmaMachine enigMach,EnigmaFile enigFile){
        this.enigMach=enigMach;
        this.enigFile=enigFile;
    }

    /**
     * testHarness1 uses 2 for loops to go through all possible letter combination
     * the output will be the encripted messages that contains the needed words
     * moreover, the method will also print in the file the letter values that leaded to the right answer
     */

    public void testHarness1() {
        try {
        line = enigFile.readFromFile();
        line=format.formatInput(line);
            enigMach.clearPlugboard();

        tryTest();
            StringBuffer newLine = new StringBuffer();
            for(char letter1 = 'A';letter1<='Z';letter1++) {
                for (char letter2 = 'A'; letter2 <= 'Z' ; letter2++) {
                        enigMach.addPlug('D',letter1);
                        enigMach.addPlug('S', letter2);

                        newLine = new StringBuffer();
                        for (int i = 0; i < line.length(); i++) {
                            char caract = line.charAt(i);
                            newLine.append(enigMach.encodeLetter(caract));

                        }
                        String output = newLine.toString();
                        if (output.indexOf(answer) != -1 && output.indexOf(daisy)!= -1) {
                            enigFile.writeToFile(newLine.toString()+'\n'+"The plugs connected were: "+"D-"+ letter1+"  and  "+"S-"+letter2);

                        }
                        enigMach.clearPlugboard();
                }
            }

        } catch(IOException e) {
        e.printStackTrace();
        }
}

    /**
     * This method only imputs the configurations for the Challenge 1
     */

    public void tryTest(){

        BasicRotor firstRotor = new BasicRotor("IV");
        BasicRotor secondRotor = new BasicRotor("III");
        BasicRotor thirdRotor = new BasicRotor("II");

        firstRotor.setPosition(8);
        secondRotor.setPosition(4);
        thirdRotor.setPosition(21);
        enigMach.addRotor(firstRotor,0);
        enigMach.addRotor(secondRotor,1);
        enigMach.addRotor(thirdRotor,2);

        Reflector reflector = new Reflector("ReflectorI");
        enigMach.addReflector(reflector);


    }
    String electric="ELECTRIC";

    /**
     * this method uses 3 for loops to get every possible combination for the position of the rotors
     * printing out the message containing the right word and the positions used to get to the right solutios
     */
    public void testHarness2(){
        try {
            line = enigFile.readFromFile();
            line=format.formatInput(line);
            challenge2();
            StringBuffer newLine = new StringBuffer();

            BasicRotor firstRotor = new BasicRotor("V");
            BasicRotor secondRotor = new BasicRotor("III");
            BasicRotor thirdRotor = new BasicRotor("II");


            enigMach.addRotor(firstRotor,0);
            enigMach.addRotor(secondRotor,1);
            enigMach.addRotor(thirdRotor,2);

            for(int pos1 = 0; pos1 <= 25 ; pos1 ++) {
                for(int pos2 = 0; pos2 <= 25;pos2 ++) {
                    for (int pos3 = 0; pos3 <= 25; pos3++) {
                        firstRotor.setPosition(pos1);
                        secondRotor.setPosition(pos2);
                        thirdRotor.setPosition(pos3);

                        newLine = new StringBuffer();
                        for (int i = 0; i < line.length(); i++) {
                            char caract = line.charAt(i);
                            newLine.append(enigMach.encodeLetter(caract));

                        }
                        String output = newLine.toString();
                        if (output.indexOf(electric) != -1) {
                            enigFile.writeToFile(newLine.toString()+'\n'+"First rotor was on position: "+pos1+'\n'+"Second rotor was on position: "+pos2+'\n'+"Third rotor was on position: "+pos3);
                            //System.out.println(output);
                        }

                    }
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method inputs the configurations for challenge 2
     */
    public void challenge2(){

        enigMach.addPlug('H','L');
        enigMach.addPlug('G','P');
        Reflector reflector = new Reflector("ReflectorI");
        enigMach.addReflector(reflector);




    }
    String java="JAVA";
    String name;
    /**
     * this method uses 3 for loops to get every possible combination for the types of the rotors
     * printing out the message containing the right word and the types used to get to the right solutios
     */
    public void testHarness3(){


        try {
            line = enigFile.readFromFile();
            line=format.formatInput(line);
            challenge3();
            StringBuffer newLine = new StringBuffer();
            for(int type1 = 1; type1 <= 5 ; type1 ++) {
                for(int type2 = 1; type2 <= 5;type2 ++) {
                    for (int type3 = 1; type3 <= 5; type3++) {
                        switchType(type1);
                        String name1= name;
                        BasicRotor firstRotor = new BasicRotor(name);
                        switchType(type2);
                        String name2=name;
                        BasicRotor secondRotor = new BasicRotor(name);
                        switchType(type3);
                        String name3= name;
                        BasicRotor thirdRotor = new BasicRotor(name);

                        firstRotor.setPosition(22);
                        secondRotor.setPosition(24);
                        thirdRotor.setPosition(23);
                        enigMach.addRotor(firstRotor,0);
                        enigMach.addRotor(secondRotor,1);
                        enigMach.addRotor(thirdRotor,2);

                        newLine = new StringBuffer();
                        for (int i = 0; i < line.length(); i++) {
                            char caract = line.charAt(i);
                            newLine.append(enigMach.encodeLetter(caract));

                        }
                        String output = newLine.toString();
                        if (output.indexOf(java) != -1) {
                            enigFile.writeToFile(newLine.toString()+'\n'+"First rotor type is: "+name1+'\n'+"Second rotor type is: "+name2+'\n'+"Third rotor type is: "+name3);
                        }

                    }
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }




    }
    public void challenge3(){


        enigMach.addPlug('M', 'F');
        enigMach.addPlug('O', 'I');


        Reflector reflector = new Reflector("ReflectorI");
        enigMach.addReflector(reflector);

    }
    private void switchType(int type) {
        switch (type){
            case 1:
                this.name="I";
                break;
            case 2:
                this.name="II";
                break;
            case 3:
                this.name="III";
                break;
            case 4:
                this.name="IV";
                break;
            case 5:
                this.name="V";
                break;
        }
    }
}
