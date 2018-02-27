import java.io.*;

public class EnigmaFile {

    EnigmaMachine enigMach = new EnigmaMachine();

    public String readFromFile() throws IOException {
        BufferedReader inputReader = new BufferedReader(new FileReader("input.txt"));
        String line = inputReader.readLine();
        inputReader.close();
        return line;
    }
    public char readPlugs() throws IOException {
        BufferedReader inputReader = new BufferedReader(new FileReader("input.txt"));
        char caract = (char) inputReader.read();
        inputReader.close();
        return caract;
    }

    public void writeToFile(String str) throws IOException {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter("output.txt"));
        outputWriter.write(str);
        outputWriter.close();
    }


    public void read() {

        String line = null;

        try {

            line = readFromFile();

            StringBuffer reader = new StringBuffer();
            for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                reader.append(enigMach.encodeLetter(c));
            }

            writeToFile(reader.toString());

        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
            System.out.println("Could not find the file.");
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage());
            System.out.println("There was no string to read from the file.");
        }

    }
}
