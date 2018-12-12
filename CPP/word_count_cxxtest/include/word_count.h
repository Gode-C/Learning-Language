/*******************************************************************************
 * Name            : word_count.cc
 * Project         : Labs
 * Module          : Lab02
 * Description     : This program counts words and numbers, except for those
 *                   found in comments.
 * Copyright       : 2017 CSCI3081W Staff. All rights reserved.
 * Original Author : Eric Van Wyk
 * Modifications by: Dan Challou, John Harwell, Cyrus Chen
 ******************************************************************************/

#ifndef LAB3_INCLUDE_WORD_COUNT_H_
#define LAB3_INCLUDE_WORD_COUNT_H_

/*******************************************************************************
 * Includes
 ******************************************************************************/
#include <regex.h>

/*******************************************************************************
 * Structure Definititions
 ******************************************************************************/
struct Results {
    int num_words;
    int num_numeric_constants;
    int num_foos;
};

/*******************************************************************************
 * Forward Declarations
 ******************************************************************************/
int consume_whitespace_and_comments(regex_t *whiteSpace, regex_t *block_comment,
                                    const char *text);
struct Results word_count(const char *text);

#endif /* LAB3_INCLUDE_WORD_COUNT_H_ */
