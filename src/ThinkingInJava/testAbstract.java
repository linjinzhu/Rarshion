package ThinkingInJava;

/**
 * Created by rarshion on 16/8/22.
 */

abstract  class Instrument{
    public int i;
    public abstract void play();
    public abstract void ajust();
}

class Wind extends Instrument{

    @Override
    public void play() {

    }

    @Override
    public void ajust() {
        
    }
}

public class testAbstract {

}
