/**
 * the TurnoverRotor class sets up the Turnovers
 * being the Rotors that rotate the Rotor following them
 * Thus, in this class, the rotate method is overridden
 */

public class TurnoverRotor extends BasicRotor {

    int turnoverPosition = 0;
    private BasicRotor nextRotor;

    public TurnoverRotor(String name, BasicRotor nextRotor) {
        super(name);
        setTurn(this.name);
        this.nextRotor = nextRotor;
    }

    /**
     * Based on it's name, the setTurn method sets the turnoverPosition
     * @param name
     */

    public void setTurn(String name){
        switch(name){
            case "I":
                turnoverPosition = 24;
                break;
            case "II":
                turnoverPosition = 12;
                break;
            case "III":
                turnoverPosition = 3;
                break;
            case "IV":
                turnoverPosition = 17;
                break;
            case "V":
                turnoverPosition = 7;
                break;
        }


    }
    public int getTurnPos() {
        return turnoverPosition;
    }

    /**
     * The new rotate method that moves the position of the next Rotor if the position of the Turnover is equal to the Turnover position
     */
    @Override
    public void rotate() {

        if (getPosition() != 25) {
            setPosition(getPosition() + 1);
            if (getPosition() == getTurnPos()) {
                nextRotor.rotate();
            }
        } else {
            setPosition(0);
        }
    }

}
