import java.util.ArrayList;
import java.util.Iterator;

public class Plugboard {
    ArrayList<Plug> plugBoard = new ArrayList<Plug>();

    public boolean addPlug(char end1,char end2) {
        Plug plug = new Plug(end1, end2);
        boolean itWorked;
        itWorked = false;
        if (plugBoard.isEmpty()){
            plugBoard.add(plug);
            itWorked = true;
        }else{
            Iterator<Plug> iterator = plugBoard.iterator();

            while(iterator.hasNext() && !iterator.next().clashesWith(plug)){
                itWorked = true;
            }

            if(itWorked == true){
                plugBoard.add(plug);
            }
        }
        return itWorked;
    }
    public int getNumPlugs(){
        return plugBoard.size();
    }
    public void clear(){
        plugBoard.clear();
    }
    public char substitute(char character){
        Iterator<Plug> iterator = plugBoard.iterator();
        if(!plugBoard.isEmpty()){
            while(iterator.hasNext()){
                character = iterator.next().encode(character);
            }
        }
        return character;
    }
}
