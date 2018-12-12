#include <cxxtest/TestSuite.h>

#include "include/word_count.h"
#include "include/regex.h"

class word_count_test_suite : public CxxTest::TestSuite {
public:

    // Some simple sample tests to illustrate the assertion macros.
    void test_addition_sample () {
        TS_ASSERT( 1 + 2 == 3 );
    }
    void test_addition_equality_sample () {
        TS_ASSERT_EQUALS( 1 + 2, 3 );
    }

    // Tests for make_regex
    // --------------------------------------------------
    /* These tests are ones that we might write to verify our
       understanding of how the functions work.  Even if we didn't
       write them and are not try to test them for bugs, writing tests
       can help understand how they do work.  */

    void test_make_regex_some_digits () {
        regex_t *re = make_regex("[0-9]+");
        TS_ASSERT(re);
    }
    void test_make_regex_xs_followed_by_ys () {
        regex_t *re = make_regex("x+y+");
        TS_ASSERT(re);
    }
    void test_make_regex_fail_unbalanced_brackets (void) {
        regex_t *re = make_regex("[0-9]+[");
        TS_ASSERT(re == NULL);
    }
    void test_make_regex_fail_illformed_backslash (void) {
        regex_t *re = make_regex("[0-9]+\\");
        TS_ASSERT(re == NULL);
    }

    /* T1. (1 test) Add a test that intentionally fails to create a
       regex because the regex string is not well formed. This test
       should be similar to [test_makeRegex_fail_illformed_backslash].
     */
     
    void test_make_regex_fail_cread_regex (void) {
        regex_t *re = make_regex("))).?;'lkhl+\\");
        TS_ASSERT(re == NULL);
    }
     
     
     

    // Tests for matchRegex
    // --------------------------------------------------
    /* These tests are like those above, they help us understand how
       to use the functions.  */

    void test_match_regex_abc_anywhere () {
        regex_t *re = make_regex("abc");
        TS_ASSERT(re);
        int num_matched_chars = match_regex(re, " abc ");
        TS_ASSERT_EQUALS(num_matched_chars, 4);
        // num_matched is number chars consumed in finding the match.
    }

    void test_match_regex_abc_at_beginning () {
        regex_t *re = make_regex("^abc");
        TS_ASSERT(re);
        int num_matched_chars = match_regex(re, "abc ");
        TS_ASSERT_EQUALS(num_matched_chars, 3);
        // num_matched is number chars consumed in finding the match.
    }

    void test_match_regex_fail_abc_anywhere () {
        regex_t *re = make_regex("abc");
        TS_ASSERT(re);
        int num_matched_chars = match_regex(re, " a bc ");
        TS_ASSERT_EQUALS(num_matched_chars, 0);
    }

    void test_match_regex_fail_abc_at_beginning () {
        regex_t *re = make_regex("^abc");
        TS_ASSERT(re);
        int num_matched_chars = match_regex(re, " abc ");
        TS_ASSERT_EQUALS(num_matched_chars, 0);
    }

    /* T2. (1 test) Add a test that correctly creates a regex that
       then fails to match because the pattern is not present in the
       regular expression.  This test should be similar to the test
       [test_matchRegex_fail_abc_at_beginning].
     */

    void test_match_regex_fail_not_present () {
        regex_t *re = make_regex("^abc");
        TS_ASSERT(re);
        int num_matched_chars = match_regex(re, " wjfkanfkjw ");
        TS_ASSERT_EQUALS(num_matched_chars, 0);
	}

    // Tests of makeRegex and matchRegex for WordCount
    // --------------------------------------------------
    /* Here we want to write tests that ensure the we have written the
       correct regular expression string for the different types of
       patterns that we need to match for the WordCount program.

       These create the regex_t and then try to match it.  These only
       need match at the beginning of the text. */

    void test_make_match_regex_word () {
        regex_t *re = make_regex("^([a-zA-Z]+)");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "something ");
        TS_ASSERT_EQUALS(num_matched_chars, 9);
    }

    /* T3. (5 tests) Write tests similar to [test_make_matchRegex_word]
       for the other patterns we care about for WordCount.  Thus we
       need a test for whitespace, block-comments, integer constants,
       floating point constants, and foo keywords.

       Write your tests below.
    */
    void test_better_one_make_match_regex_word_space () {
        regex_t *re = make_regex("^([a-zA-Z]+)");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "thisgh whahahaha");
        TS_ASSERT_EQUALS(num_matched_chars, 6);
    }
    
    void test_even_better_one_make_match_regex_word_block () {
        regex_t *re = make_regex("^([a-zA-Z]+)");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "what/*ata*/haha");
        TS_ASSERT_EQUALS(num_matched_chars, 4);
    }    
    
    
    void test_real_better_one_make_match_regex_word_int () {
        regex_t *re = make_regex("^([a-zA-Z]+)");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "thisistheend36right?");
        TS_ASSERT_EQUALS(num_matched_chars, 12);
    }    
    
    void test_real_better_one_make_match_regex_word_float () {
        regex_t *re = make_regex("^([a-zA-Z]+)");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "five6.337saef");
        TS_ASSERT_EQUALS(num_matched_chars, 4);
    }       
    
    void test_real_better_one_make_match_regex_word_foo () {
        regex_t *re = make_regex("^([a-zA-Z]+)");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "thisfoo");
        TS_ASSERT_EQUALS(num_matched_chars, 7);
    }        
    

    // Tests for consumeWhiteSpaceAndComments.
    // --------------------------------------------------
    /* The tests above should confirm that we can make and match
       individual regular expressions for white space and block
       comments.  We now need to test that
       [consumeWhiteSpaceAndComments] properly does this and can match
       a sequence of these patterns. */

    /* T4. (3 tests) Write three tests that show
       [consumeWhiteSpaceAndComments] working on a sequence of
       white-space and block comments.  One of these should test that
       this function does the right thing when that sequence include 0
       such items.

       Write your tests below.
    */
    void test_real_better_one_make_match_regex_word_space () {
        regex_t *re = make_regex("^[\n\t\r ]+");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, " only one");
        TS_ASSERT_EQUALS(num_matched_chars, 1);
    }



    void test_real_better_one_make_match_regex_word_commant () {
        regex_t *re = make_regex("^/\\*([^\\*]|\\*+[^\\*/])*\\*+/");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "/*hello*/thisfoo");
        TS_ASSERT_EQUALS(num_matched_chars, 9);
    }
    
    void test_real_better_one_make_match_regex_word_none_of_them () {
        regex_t *re = make_regex("/*hello*/thisfoo");
        TS_ASSERT (re);
        int num_matched_chars = match_regex(re, "five6.337saef");
        TS_ASSERT_EQUALS(num_matched_chars, 0);
    }
    
    
    
    
    // Tests for wordCount.
    // --------------------------------------------------
    /* Having shown the the functions used by wordCount pass our
       tests, we have some confidence in them.  We can not test
       wordCount directly. */

    /* T5. (4 tests) Tests that show each element (word, integer
       constant, float constant, and Foo keyword) can be recognized
       when it is the only thing in the text besides perhaps some
       white space.

       We've provide an example of this for words.  Add four more
       tests, one for each other element.
     */

    void test_word_count_single_word () {
        TS_ASSERT_EQUALS(word_count(" something ").num_words, 1);
    }

    void test_word_count_single_word2 () {
        TS_ASSERT_EQUALS(word_count(" any one").num_words, 2);
    }

    void test_word_count_single_int () {
        TS_ASSERT_EQUALS(word_count(" 133 ").num_numeric_constants, 1);
    }
    
    void test_word_count_single_float () {
        TS_ASSERT_EQUALS(word_count(" 133.25 ").num_numeric_constants, 1);
    }
    
    void test_word_count_single_foo () {
        TS_ASSERT_EQUALS(word_count(" foo foo / foo ").num_foos, 3);
    }
    


    /* T6. (2 tests) We can now write some tests that include several
       elements. These test should check the contents of the returned
       structure to see that the right number of words, numbers and
       foo keywords have been matched.

       You should now write at least two tests of this type.  You will
       want to consider the case when there are zero words (or numbers
       or foo keywords) in the text.

       Write your tests below.
     */
     
     
    void final_test_01 () {
    const char *test = "I have been waiting for 8 years, you foo.";
        TS_ASSERT_EQUALS(word_count(test).num_foos, 1);
        TS_ASSERT_EQUALS(word_count(test).num_numeric_constants, 1);   
        TS_ASSERT_EQUALS(word_count(test).num_words, 7);     
    } 
     
     
    void final_test_02 () {
    const char *test = "tbh, I think  this is going to be really fun with 1 2 3 4 5 yeah!";
        TS_ASSERT_EQUALS(word_count(test).num_foos, 0);
        TS_ASSERT_EQUALS(word_count(test).num_numeric_constants, 5);    
        TS_ASSERT_EQUALS(word_count(test).num_words, 12);     
    } 
     
     
     
     
     
     
};
