/*******************************************************************************
 * Name            : regex.h
 * Project         : Labs
 * Module          : Lab03
 * Description     : Header file for regex module
 * Copyright       : 2017 CSCI3081W Staff. All rights reserved.
 * Original Author : Eric Van Wyk
 * Modifications by: Dan Challou, John Harwell, Cyrus Chen
 ******************************************************************************/

#ifndef LAB3_INCLUDE_REGEX_H_
#define LAB3_INCLUDE_REGEX_H_

/*******************************************************************************
 * Includes
 ******************************************************************************/
#include <regex.h>

/*******************************************************************************
 * Forward Declarations
 ******************************************************************************/
regex_t *make_regex(const char* pattern);
int match_regex(regex_t *, const char *);

#endif /* LAB3_INCLUDE_REGEX_H_ */
