import java.util.ArrayList;

/**
 * The Rotor class is the basic version of each BasicRotor, Reflector or TurnoverRotor
 */
abstract class Rotor {
    String name;
    int position;

    public Rotor(String name) {
        this.name = name;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
    }
    abstract void initialise(String name);
    abstract int substitute(int position);

}
