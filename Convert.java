public class Convert {

    public String formatInput(String input) {
        input = input.replaceAll("\\s+","");
        input = input.replaceAll("[0-9]+","");
        input = input.replaceAll(",","");
        input = input.replaceAll("\\.","");
        input = input.toUpperCase();

        return input;
    }
}
