// Cyrus Chen
// chen3736
// indicate lines that are higly likely to need alterations. 
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <pthread.h>            // **CHA
#include <sys/sem.h>
#include <time.h>

#define N_PHILOSOPHERS  5       // Number of philosophers

const int MEALS_TO_FINISH = 10; // Number of iterations before philosophers finish
const int MAX_DELAY = 50000;    // Maximum delay in nanos between meal iterations

pthread_mutex_t utensils[N_PHILOSOPHERS];   // **CHANGE** to mutexes 

void *philosopher(void *args);         // **CHANGE** to have prototype compatible with thread entry points

int main(){
  setvbuf(stdout, NULL, _IONBF, 0); 
  int i, status;
  pthread_t phil[N_PHILOSOPHERS];   // **CHANGE** to thread structures
  printf("The Dining Swansons (Philosophers) Problem\n");

  // Parent thread only:
  // 
  // Allocate utensils: mutexes
  for(i=0; i<N_PHILOSOPHERS; i++){
    pthread_mutex_init(&utensils[i],NULL);

  }

  // Parent generates child processes
  for(i=0; i < N_PHILOSOPHERS; i++){
    pthread_create(&phil[i],NULL,philosopher, (void*) i);
  

  }


  // Parent waits on all children to finish
  for(i = 0; i < N_PHILOSOPHERS; i++) {
    pthread_join(phil[i], (void **) NULL);

  }

  printf("JJ: All Swansons finished, cleaning up the diner\n");

  // Eliminate the utensils and table semaphores
  for(i=0; i<N_PHILOSOPHERS; i++){
    pthread_mutex_destroy(&utensils[i]);
   // semctl(utensils[i], 0, IPC_RMID, 0); // **CHANGE** to clean up mutexes
  }

  return 0;
}

// Code for dining philosopher child processes 
void* philosopher(void *arg){         // **CHANGE** to have prototype compatible with thread entry points
    int n = (int) arg;

  int i, first, second;

  srand(time(NULL));            // Seed random number generator

  // Avoid deadlock via slightly different order of utensil requests
  // for last philospher

  // first utensil to get, most go for n first, last philospher goes for 0 first
  first =  (n != N_PHILOSOPHERS-1)? n     : 0;                
  // second utensil to get, last philopher goes for n second
  second = (n != N_PHILOSOPHERS-1)? n + 1 : n; 

  printf("Swanson %d wants utensils %d and %d\n",n,first,second);
  printf("Swanson %d at the table\n", n);

  // Main loop of thinking/eating cycles
  for(i = 0; i < MEALS_TO_FINISH; i++) {
    int sleep_time = rand() % MAX_DELAY;
    usleep(sleep_time);         // sleep for for a short time

    printf("%2d: Swanson %d is contemplating his awesomeness ...\n", i,n);

    // get first utensil
    pthread_mutex_lock(&utensils[first]);
    

    printf("%2d: Swanson %d got utensil %d\n",i,n,first);

    // get second utensil
    pthread_mutex_lock(&utensils[second]);

    printf("%2d: Swanson %d got utensil %d\n",i,n,second);

    printf("%2d: Swanson %d is eating an egg ...\n", i,n);
    usleep(sleep_time);         // sleep for for a short time

    // release first utensil
    pthread_mutex_unlock(&utensils[first]);
         


    // release second utensil
    pthread_mutex_unlock(&utensils[second]);

  }

  printf("Swanson %d leaving the diner\n",n);
  pthread_exit(&n);
  

}
