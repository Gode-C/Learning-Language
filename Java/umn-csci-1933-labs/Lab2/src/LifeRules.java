/**
 * Created by chen3736 on 9/22/15.
 */
public class LifeRules {

    public boolean getNextState(boolean currentState, int numNeighbors) {


        if (currentState == true && numNeighbors > 3) {
            currentState = false;
        }

        else if (currentState==true && numNeighbors == 1 || numNeighbors == 0){

            currentState = false;
        }
        else if (currentState == true && numNeighbors == 2) {
            currentState = true;
        }
        else if (currentState == false && numNeighbors == 3){

        currentState = true;

        }

        else if (currentState == false && numNeighbors == 6){

            currentState = true;
        }

        else {

            currentState = currentState;
        }

        return currentState;






    }}
