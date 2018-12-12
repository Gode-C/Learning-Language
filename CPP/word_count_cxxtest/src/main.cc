/*******************************************************************************
 * Name            : read_input.cc
 * Project         : Labs
 * Module          : Lab03
 * Description     : This program counts words, numeric constants, and case-
 *                   insensitive "Foo" keywords, except for those found in 
 *                   comments that are contained in a file.  The file name is 
 *                   provided as a command line argument.
 *
 * Copyright       : 2017 CSCI3081W Staff. All rights reserved.
 * Original Author : Eric Van Wyk
 * Modifications by: Dan Challou, John Harwell, Cyrus Chen
 ******************************************************************************/

/*******************************************************************************
 * Includes
 ******************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include "include/word_count.h"
#include "include/read_input.h"

/*******************************************************************************
 * Functions
 ******************************************************************************/
int main(int argc, char **argv) {
  char *text = read_input(argc, argv);
  char * text_p = text;
  // If reading in input failed, exit with return code of 1.
  if (text == NULL) {
    return 1;
  } else {
    struct Results res = word_count(text);
    printf("%d\n", res.num_words);
    printf("%d\n", res.num_numeric_constants);
    printf("%d\n", res.num_foos);
  }
  delete[] text_p;
} /* main() */
