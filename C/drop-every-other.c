
/*******************************************************************************
 * Name            : hwk_01.c
 * Project         : CSCI 5106
 * Description     : Implementation of input reader utility
 * Author          : Cyrus Chen
 ******************************************************************************/

//    compile ->     gcc hwk_01.c
//    run ->         ./a.out
//        keep enter numbers, negatives will trigger output



#include <stdio.h>
#include <stdlib.h>
// Uses a loop to take input, then print every other element from the input list


// inputReader ask the user to input integer, and store the input til negative
// take a pointer to int, modify the value and return the number of elements
int inputReader(int* inputlist) {
    int userinput = 0;
    int counter = 0;
    while(1){       // loop
        printf("Enter a number, end with negatives ");
        if (scanf("%d",&userinput) == 0) {
        printf("Invalid input, integers please \n");
            exit(0);
            
        } else {

            if (userinput >= 0) {   // when inputs >= 0
                inputlist[counter] = userinput; // store value
                counter++;
            } else break;   // negative input, break out from the loop
        }
    }
    
    
    return counter;
}

// printResult takes a pointer of int and the number of elements.
// print every other element in that pointer
int printResult(int* inputlist, int counter) {
    int i = 0;
    for(; i < counter; i++) {
        if (i % 2 == 0) {   // if even, since i starts with 0
        printf("%d ",inputlist[i]);
        }
    }
    return 0;
}



int main(int argc, char** argv) {
    int *userinput = malloc(sizeof(int));   //malloc memory for input
    int counter = inputReader(userinput);
    printResult(userinput, counter);
    free(userinput);
    printf("\n");
    return 0;
}
