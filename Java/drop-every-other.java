/*  Cyrus Chen
    chen3736
 
    compile ->     javac hwk_01.java
    run ->         java hwk_01
    
            keep enter numbers, negatives will trigger output
*/

import java.util.*;



public class hwk_01 {

/*  main that only make calls to methods.*/
    public static void main(String[] args) {

        hwk_01.printResult(hwk_01.inputReader());
    }

/*  This method take user inputs and store in an array list of integers
    using Scanner class to take inputs   */
    public static ArrayList<Integer> inputReader(){

        int getint = 0;
        int loopend = 0;
        Scanner read = new Scanner(System.in);
        ArrayList<Integer> userInputs = new ArrayList<Integer>();

        while (loopend >= 0){
            System.out.println("Enter a number, end with negatives");
            getint = read.nextInt();
            if (getint >= 0){
                userInputs.add(getint);
            }
            else{
                loopend = -1;
            }
        }
        return userInputs;
    }
    
/*  This method loop through the array and store every other elements into
    a new array, then print out the new array.  */    
    
    public static void printResult(ArrayList<Integer> inputlist){
        
        ArrayList<Integer> outputlist = new ArrayList<Integer>();
        
        for(int i=0; i<inputlist.size(); i++){
            if (i % 2 == 0){
                outputlist.add(inputlist.get(i));
            }
        }
        System.out.println(outputlist);
    }
}
