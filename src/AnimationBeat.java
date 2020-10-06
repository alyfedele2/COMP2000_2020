
public class AnimationBeat {
    private long started;
    private long a; // length of phase a
    private long b; // length of phase b
    private long c; // length of phase c
    private static AnimationBeat beat; //Singleton
    
    private AnimationBeat(){ //Changed to private for Singleton implementation
        started = System.currentTimeMillis();
        this.a = 5000; //5 sec
        this.b = 500; //1/2 sec
        this.c = 500;
    }

    // returns which phase the animation is currently in
    public char inPhase(){
        long currTime = System.currentTimeMillis();
        long rem = (currTime - started) % (a + b);
        if (rem > a + b){
            return 'c'; //?
        } else if (rem > a) {
            return 'b';
        } else {
            return 'c';
        }
    }

    // returns a number (out of 100) showing the percentage completion of this phase
    public long phaseCompletion(){ 
        long currTime = System.currentTimeMillis();
        long rem = (currTime - started) % (a + b+c);
        if (rem > a+b){
            return ((rem -a-b)*100)/c;
        } else if (rem > a){
            return ((rem - a)*100)/b;
        } else {
            return rem*100/a;
        }
    }

    public static AnimationBeat getBeat() { //Singleton
        return beat;
    }
}
