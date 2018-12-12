/*******************************************************************************
 * Name            : read_input.cpp
 * Project         : Labs
 * Module          : Lab01
 * Description     : A sample file to read the contents of a file into a
 *                   character buffer
 * Copyright       : 2017 CSCI3081W Staff. All rights reserved.
 * Original Author : Eric Van Wyk
 * Modifications by: Dan Challou
 * Modifications by: John Harwell
 * Modifications by: <Cyrus Chen>
 *
 ******************************************************************************/

/*******************************************************************************
 * Includes
 ******************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>

/*******************************************************************************
 * Functions
 ******************************************************************************/
int main(int argc, char **argv) {
  printf("Reading a file into a character buffer.\n");

  // Verify that a file name is provided and that the file exists.
  // Use some new C++ stream features.
  if (argc <= 1) {
    printf("Usage: readInput <filename>\n");
    return 1;
  }

  printf("Opening file \"%s\".\n", argv[1]);

  FILE *in_fp;
  in_fp = fopen(argv[1], "r");
  if (in_fp == NULL) {
    printf("File \"%s\" not found.\n", argv[1]);
    return 2;
  }
  // Determine the size of the file, used to allocate the char buffer.
  struct stat filestatus;
  stat(argv[1], &filestatus);

  int filesize = filestatus.st_size + 1;  // +1 for terminating null char

  // Allocate space for the character buffer.
  char *buffer = new char[filesize];
  int index = 0;
  char ch = getc(in_fp);
  int aa,scount = 0;

  while (ch != EOF) {
    buffer[index] = ch;
    index++;
    ch = getc(in_fp);
  }
  buffer[index] = '\0';
  
  for (aa = 0; aa <= index; aa++) 
  	{if (buffer[aa] == 's') {scount++;}}

  printf("The number of S's in the file is %d\n\n", scount);
  delete[] buffer;
  return 0;
} /* main() */
