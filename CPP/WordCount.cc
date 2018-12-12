/*******************************************************************************
 * Name            : word_count.cc
 * Project         : Labs
 * Module          : Lab02
 * Description     : This program counts words and numbers, except for those
 *                   found in comments.
 * Copyright       : 2017 CSCI3081W Staff. All rights reserved.
 * Original Author : Eric Van Wyk
 * Modifications by: Cyrus Chen
 ******************************************************************************/

/*******************************************************************************
 * Includes
 ******************************************************************************/
#include <stdio.h>
#include <stdlib.h>

#include <regex.h>
#include <sys/stat.h>
#include <sys/types.h>

/*******************************************************************************
 * Forward Declarations
 ******************************************************************************/
char *read_input(int argc, char **argv);

void make_regex(regex_t *regex, const char *pattern);

int match_regex(regex_t *re, const char *text);

int consume_whitespace_and_comments(regex_t *whiteSpace, regex_t *block_comment,
                                    const char *text);

/*******************************************************************************
 * Functions
 ******************************************************************************/
int main(int argc, char **argv) {
  char *text = read_input(argc, argv);

  // If reading in input failed, exit with return code of 1.
  if (text == NULL) {
    return 1;
  }

  // Create the compiled regular expressions.
  regex_t white_space;
  make_regex(&white_space, "^[\n\t\r ]+");

  regex_t block_comment;
  make_regex(&block_comment, "^/\\*([^\\*]|\\*+[^\\*/])*\\*+/");

  regex_t word;
  make_regex(&word, "^([a-zA-Z]+)");

  regex_t integer_const;
  make_regex(&integer_const, "^[0-9]+\\.?[0-9]*");
  
  /*Adding a escaped "." to finding the floting point values followed by one or
  	*more numbers, using "?" to state the "." could be there or not too keep
  	*the integers in count
  	*/
  
  regex_t foo;
  make_regex(&foo, "^(Foo|foo)");
  
  /* search for the text Foo or foo*/
  

  /*
   * This enumerated type is used to keep track of what kind of construct was
   * matched.
   */
  enum match_type { num_match, word_match, no_match, foo_match } match_type;

  int num_matched_chars = 0;

  // Consume leading white space and comments
  num_matched_chars =
      consume_whitespace_and_comments(&white_space, &block_comment, text);
  /*
   * text is a character pointer that points to the current beginning of the
   * array of characters in the input. Adding an integer value to it advances
   * the pointer that many elements in the array. Thus, text is increased so
   * that it points to the current location in the input.
   */
  text = text + num_matched_chars;

  int max_num_matched_chars = 0;
  int num_words = 0, num_numeric_consts = 0;
  int num_foo = 0;

  while (text[0] != '\0') {
    max_num_matched_chars = 0;
    match_type = no_match;
    
    // Try to match foo
    num_matched_chars = match_regex(&foo, text);
    if (num_matched_chars > max_num_matched_chars) {
      max_num_matched_chars = num_matched_chars;
      match_type = foo_match;
    }

    // Try to match a word
    num_matched_chars = match_regex(&word, text);
    if (num_matched_chars > max_num_matched_chars) {
      max_num_matched_chars = num_matched_chars;
      match_type = word_match;
    }

    // Try to match an integer constant
    num_matched_chars = match_regex(&integer_const, text);
    if (num_matched_chars > max_num_matched_chars) {
      max_num_matched_chars = num_matched_chars;
      match_type = num_match;
    }

    /*
     * max_num_matched_chars is used to ensure that the regular expression that
     * matched the longest string is the one that we use. If two match then
     * priority is given to the first one that was tried. This is done by the
     * comparison (num_matched_chars > max_num_matched_chars) which is a
     * strictly greater than comparison.
    */

	switch (match_type) {
		case foo_match:
			++num_foo;
			break;
		case word_match:
			++num_words;
			break;
		case num_match:
			++num_numeric_consts;
			break;
		case no_match:
			break;
    } /* switch() */

    if (match_type == no_match) {
      // If we didn't match anything, then just skip the first character.
      text = text + 1;
    } else {
      // Consume the characters that were matched.
      text = text + max_num_matched_chars;
    }

    // Consume white space and comments before trying again for
    // another word or integer.
    num_matched_chars =
        consume_whitespace_and_comments(&white_space, &block_comment, text);
    text = text + num_matched_chars;
  }

  printf("number of words: %d\n", num_words);
  printf("number of numbers:%d\n", num_numeric_consts);
  printf("number of foo: %d\n", num_foo);
/*  if (text) {
    free(text);
  }*/
  return 0;
} /* main() */

int consume_whitespace_and_comments(regex_t *white_space,
                                    regex_t *block_comment,
                                    const char *text) {
  int num_matched_chars = 0;
  int total_num_matched_chars = 0;
  int still_consuming_white_space;

  do {
    still_consuming_white_space = 0;  // exit loop if not reset by a match

    // Try to match white space
    num_matched_chars = match_regex(white_space, text);
    total_num_matched_chars += num_matched_chars;
    if (num_matched_chars > 0) {
      text = text + num_matched_chars;
      still_consuming_white_space = 1;
    }

    // Try to match block comments
    num_matched_chars = match_regex(block_comment, text);
    total_num_matched_chars += num_matched_chars;
    if (num_matched_chars > 0) {
      text = text + num_matched_chars;
      still_consuming_white_space = 1;
    }
  } while (still_consuming_white_space);

  return total_num_matched_chars;
} /* consume_whitespace_and_comments() */

void make_regex(regex_t *re, const char *pattern) {
  int rc;

  /*
   * "Compile" the regular expression. This sets up the regex to do the
   * matching specified by the regular expression given as a character string.
   */
  rc = regcomp(re, pattern, REG_EXTENDED);

  if (rc != 0) {
    printf("Error in compiling regular expression.\n");
    size_t length = regerror(rc, re, NULL, 0);
    char *buffer = reinterpret_cast<char *>(malloc(sizeof(char) * length));
    (void)regerror(rc, re, buffer, length);
    printf("%s\n", buffer);
  }
} /* make_regex() */

int match_regex(regex_t *re, const char *text) {
  int status;
  const int kNsub = 1;
  regmatch_t matches[kNsub];

  /*
   * Execute the regular expression match against the text. If it matches, the
   * beginning and ending of the matched text are stored in the first element
   * of the matches array.
   */
  status = regexec(re, text, static_cast<size_t>(kNsub), matches, 0);

  if (status == REG_NOMATCH) {
    return 0;
  } else {
    return matches[0].rm_eo;
  }
} /* match_regex() */

char *read_input(int argc, char **argv) {
  // Verify that a file name is provided and that the file exists.
  // Use some new C++ stream features.
  if (argc <= 1) {
    printf("Usage: word_count <filename>\n");
    return NULL;
  }

  // ifstream in(argv[1]);
  FILE *in_fp;
  in_fp = fopen(argv[1], "r");
  if (in_fp == NULL) {
    printf("File \"%s\" not found.\n", argv[1]);
    return NULL;
  }

  // Determine the size of the file, used to allocate the char buffer.
  struct stat filestatus;
  stat(argv[1], &filestatus);

  int filesize = filestatus.st_size + 1;  // +1 for terminating null char

  // Allocate space for the character buffer.
  char *buffer = reinterpret_cast<char *>(malloc(sizeof(char) * filesize));

  int index = 0;
  int ch = getc(in_fp);

  while (ch != EOF) {
    buffer[index] = ch;
    index++;
    ch = getc(in_fp);
  } /* while() */
  buffer[index] = '\0';

  return buffer;
} /* read_input() */
