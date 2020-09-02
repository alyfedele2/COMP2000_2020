import java.util.*; 

public class moveRandom implements Strategy {

    //@Override
    public void movementStrategy(Actor actor) {
        //Allows CPU cell to move in a random direction. Each Actor / actor instance is
        //provided with a specific strategy. Strategy is used whenever actor needs to move

        List<Cell> possibleLocs = Stage.getClearRadius(actor.loc, actor.moves);
        int moveCPUChooses = (new Random()).nextInt(possibleLocs.size());
        actor.setLocation(possibleLocs.get(moveCPUChooses));

    }

}