/*******************************************************************************
 * Name            : regex_test.cc
 * Project         : Labs
 * Module          : Lab02
 * Description     : A simple test program for the C regex engine.
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
#include <sys/types.h>

/*******************************************************************************
 * Forward Declarations
 ******************************************************************************/
void match(const char *string, const char *pattern);

/*******************************************************************************
 * Functions
 ******************************************************************************/
int main() {
  // Some strings for regular expressions.
  const char *word_re = "^[a-zA-Z]+";
  const char *white_space_re = "^([\n\t\r ])+";
  const char *left_paren_re = "^\\(";

  /*
   * The match function lets you experiment with regular expressions. The first
   * argument is the text to match against. The second is the string for the
   * regular expression. To match only against the beginning of the text the
   * regular expression must begin with the ^ character.
   */
  match("    \n   1234234 some text to match against", word_re);
  match("Aword ", word_re);
  match("( left paren)", left_paren_re);
} /* main() */

/* An function to experiment with the regex.h library. */
void match(const char *text, const char *pattern) {
  int status;
  regex_t re;
  int rc;

  /*
   * "Compile" the regular expression.  This sets up the regex to do the
   *  matching specified by the regular expression given as a character string
   */
  rc = regcomp(&re, pattern, REG_EXTENDED);

  if (rc != 0) {
    printf("Error in compiling regular expression.\n");
    size_t length = regerror(rc, &re, NULL, 0);
    char *buffer = reinterpret_cast<char *>(malloc(sizeof(char) * length));
    (void)regerror(rc, &re, buffer, length);
    printf("%s\n", buffer);
  }

  const int kNsub = 1;
  regmatch_t matches[kNsub];

  /*
   * Execute the regular expression match against the text.  If it matches, the
   * beginning and ending of the matched text are stored in the first element of
   * the matches array.
   */
  status = regexec(&re, text, static_cast<size_t>(kNsub), matches, 0);

  if (status == REG_NOMATCH) {
    printf("No match\n");
  } else {
    printf("A match\n");
    printf("start: %d\n", matches[0].rm_so);
    printf("end: %d\n", matches[0].rm_eo);
  }

  regfree(&re);
} /* match() */
