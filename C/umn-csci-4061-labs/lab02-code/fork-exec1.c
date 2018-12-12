#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void){

  char *child_argv[] = {"ls","-l","-ah",NULL};
  char *child_cmd = "ls";
  printf("Running command '%s'\n",child_cmd);
  printf("------------------\n");
  
  pid_t child =fork();
  wait(NULL);
  if (child == 0)
  	execvp(child_cmd,child_argv);
  printf("------------------\n");
  printf("Finished\n");
  return 0;
}
  
