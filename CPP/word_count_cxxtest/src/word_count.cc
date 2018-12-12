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

#include <sys/stat.h>
#include <sys/types.h>

#include "include/regex.h"
#include "include/read_input.h"

/*******************************************************************************
 * Forward Declarations
 ******************************************************************************/
struct Results {
    int num_words;
    int num_numeric_constants;
    int num_foos;
};


int consume_whitespace_and_comments(regex_t *whiteSpace, regex_t *block_comment,
                                    const char *text);

/*******************************************************************************
 * Functions
 
 ******************************************************************************/
struct Results word_count(const char *text) {


  // Create the compiled regular expressions.
  // making the calls compile with the new version of make_regex
  
  regex_t *white_space = make_regex("^[\n\t\r ]+");

  regex_t *block_comment = make_regex("^/\\*([^\\*]|\\*+[^\\*/])*\\*+/");

  regex_t *word = make_regex("^([a-zA-Z]+)");

  regex_t *integer_const = make_regex("^[0-9]+\\.?[0-9]*");
  
  regex_t *foo = make_regex("^(Foo|foo)");
  
  /* search for the text Foo or foo*/
  

  /*
   * This enumerated type is used to keep track of what kind of construct was
   * matched.
   */
  enum match_type { num_match, word_match, no_match, foo_match } match_type;

  int num_matched_chars = 0;

  // Consume leading white space and comments
  num_matched_chars =
      consume_whitespace_and_comments(white_space, block_comment, text);


  text = text + num_matched_chars;

  int max_num_matched_chars = 0;
  int num_words = 0, num_numeric_constants = 0;
  int num_foos = 0;

  while (text[0] != '\0') {
    max_num_matched_chars = 0;
    match_type = no_match;
    
    // Try to match foo
    num_matched_chars = match_regex(foo, text);
    if (num_matched_chars > max_num_matched_chars) {
      max_num_matched_chars = num_matched_chars;
      match_type = foo_match;
    }

    // Try to match a word
    num_matched_chars = match_regex(word, text);
    if (num_matched_chars > max_num_matched_chars) {
      max_num_matched_chars = num_matched_chars;
      match_type = word_match;
    }

    // Try to match an integer constant
    num_matched_chars = match_regex(integer_const, text);
    if (num_matched_chars > max_num_matched_chars) {
      max_num_matched_chars = num_matched_chars;
      match_type = num_match;
    }


	switch (match_type) {
		case foo_match:
			++num_foos;
			break;
		case word_match:
			++num_words;
			break;
		case num_match:
			++num_numeric_constants;
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
        consume_whitespace_and_comments(white_space, block_comment, text);
    text = text + num_matched_chars;
  }


	struct Results result;
	result.num_words = num_words;
	result.num_numeric_constants = num_numeric_constants;
	result.num_foos = num_foos;




  return result;

/*  if (text) {
    free(text);
  }*/

} /* word_count() */

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
