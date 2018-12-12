/* Generated file, do not edit */

#ifndef CXXTEST_RUNNING
#define CXXTEST_RUNNING
#endif

#define _CXXTEST_HAVE_STD
#define _CXXTEST_HAVE_EH
#define _CXXTEST_ABORT_TEST_ON_FAIL
#include <cxxtest/TestListener.h>
#include <cxxtest/TestTracker.h>
#include <cxxtest/TestRunner.h>
#include <cxxtest/RealDescriptions.h>
#include <cxxtest/TestMain.h>
#include <cxxtest/ErrorPrinter.h>

int main( int argc, char *argv[] ) {
 int status;
    CxxTest::ErrorPrinter tmp;
    CxxTest::RealWorldDescription::_worldName = "cxxtest";
    status = CxxTest::Main< CxxTest::ErrorPrinter >( tmp, argc, argv );
    return status;
}
bool suite_word_count_test_suite_init = false;
#include "/home/chen3736/3081/individual/repo-chen3736/labs/lab_03/tests/word_count_tests.h"

static word_count_test_suite suite_word_count_test_suite;

static CxxTest::List Tests_word_count_test_suite = { 0, 0 };
CxxTest::StaticSuiteDescription suiteDescription_word_count_test_suite( "tests/word_count_tests.h", 6, "word_count_test_suite", suite_word_count_test_suite, Tests_word_count_test_suite );

static class TestDescription_suite_word_count_test_suite_test_addition_sample : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_addition_sample() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 10, "test_addition_sample" ) {}
 void runTest() { suite_word_count_test_suite.test_addition_sample(); }
} testDescription_suite_word_count_test_suite_test_addition_sample;

static class TestDescription_suite_word_count_test_suite_test_addition_equality_sample : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_addition_equality_sample() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 13, "test_addition_equality_sample" ) {}
 void runTest() { suite_word_count_test_suite.test_addition_equality_sample(); }
} testDescription_suite_word_count_test_suite_test_addition_equality_sample;

static class TestDescription_suite_word_count_test_suite_test_make_regex_some_digits : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_make_regex_some_digits() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 24, "test_make_regex_some_digits" ) {}
 void runTest() { suite_word_count_test_suite.test_make_regex_some_digits(); }
} testDescription_suite_word_count_test_suite_test_make_regex_some_digits;

static class TestDescription_suite_word_count_test_suite_test_make_regex_xs_followed_by_ys : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_make_regex_xs_followed_by_ys() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 28, "test_make_regex_xs_followed_by_ys" ) {}
 void runTest() { suite_word_count_test_suite.test_make_regex_xs_followed_by_ys(); }
} testDescription_suite_word_count_test_suite_test_make_regex_xs_followed_by_ys;

static class TestDescription_suite_word_count_test_suite_test_make_regex_fail_unbalanced_brackets : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_make_regex_fail_unbalanced_brackets() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 32, "test_make_regex_fail_unbalanced_brackets" ) {}
 void runTest() { suite_word_count_test_suite.test_make_regex_fail_unbalanced_brackets(); }
} testDescription_suite_word_count_test_suite_test_make_regex_fail_unbalanced_brackets;

static class TestDescription_suite_word_count_test_suite_test_make_regex_fail_illformed_backslash : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_make_regex_fail_illformed_backslash() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 36, "test_make_regex_fail_illformed_backslash" ) {}
 void runTest() { suite_word_count_test_suite.test_make_regex_fail_illformed_backslash(); }
} testDescription_suite_word_count_test_suite_test_make_regex_fail_illformed_backslash;

static class TestDescription_suite_word_count_test_suite_test_make_regex_fail_cread_regex : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_make_regex_fail_cread_regex() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 46, "test_make_regex_fail_cread_regex" ) {}
 void runTest() { suite_word_count_test_suite.test_make_regex_fail_cread_regex(); }
} testDescription_suite_word_count_test_suite_test_make_regex_fail_cread_regex;

static class TestDescription_suite_word_count_test_suite_test_match_regex_abc_anywhere : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_match_regex_abc_anywhere() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 59, "test_match_regex_abc_anywhere" ) {}
 void runTest() { suite_word_count_test_suite.test_match_regex_abc_anywhere(); }
} testDescription_suite_word_count_test_suite_test_match_regex_abc_anywhere;

static class TestDescription_suite_word_count_test_suite_test_match_regex_abc_at_beginning : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_match_regex_abc_at_beginning() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 67, "test_match_regex_abc_at_beginning" ) {}
 void runTest() { suite_word_count_test_suite.test_match_regex_abc_at_beginning(); }
} testDescription_suite_word_count_test_suite_test_match_regex_abc_at_beginning;

static class TestDescription_suite_word_count_test_suite_test_match_regex_fail_abc_anywhere : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_match_regex_fail_abc_anywhere() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 75, "test_match_regex_fail_abc_anywhere" ) {}
 void runTest() { suite_word_count_test_suite.test_match_regex_fail_abc_anywhere(); }
} testDescription_suite_word_count_test_suite_test_match_regex_fail_abc_anywhere;

static class TestDescription_suite_word_count_test_suite_test_match_regex_fail_abc_at_beginning : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_match_regex_fail_abc_at_beginning() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 82, "test_match_regex_fail_abc_at_beginning" ) {}
 void runTest() { suite_word_count_test_suite.test_match_regex_fail_abc_at_beginning(); }
} testDescription_suite_word_count_test_suite_test_match_regex_fail_abc_at_beginning;

static class TestDescription_suite_word_count_test_suite_test_match_regex_fail_not_present : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_match_regex_fail_not_present() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 95, "test_match_regex_fail_not_present" ) {}
 void runTest() { suite_word_count_test_suite.test_match_regex_fail_not_present(); }
} testDescription_suite_word_count_test_suite_test_match_regex_fail_not_present;

static class TestDescription_suite_word_count_test_suite_test_make_match_regex_word : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_make_match_regex_word() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 111, "test_make_match_regex_word" ) {}
 void runTest() { suite_word_count_test_suite.test_make_match_regex_word(); }
} testDescription_suite_word_count_test_suite_test_make_match_regex_word;

static class TestDescription_suite_word_count_test_suite_test_better_one_make_match_regex_word_space : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_better_one_make_match_regex_word_space() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 125, "test_better_one_make_match_regex_word_space" ) {}
 void runTest() { suite_word_count_test_suite.test_better_one_make_match_regex_word_space(); }
} testDescription_suite_word_count_test_suite_test_better_one_make_match_regex_word_space;

static class TestDescription_suite_word_count_test_suite_test_even_better_one_make_match_regex_word_block : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_even_better_one_make_match_regex_word_block() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 132, "test_even_better_one_make_match_regex_word_block" ) {}
 void runTest() { suite_word_count_test_suite.test_even_better_one_make_match_regex_word_block(); }
} testDescription_suite_word_count_test_suite_test_even_better_one_make_match_regex_word_block;

static class TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_int : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_int() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 140, "test_real_better_one_make_match_regex_word_int" ) {}
 void runTest() { suite_word_count_test_suite.test_real_better_one_make_match_regex_word_int(); }
} testDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_int;

static class TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_float : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_float() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 147, "test_real_better_one_make_match_regex_word_float" ) {}
 void runTest() { suite_word_count_test_suite.test_real_better_one_make_match_regex_word_float(); }
} testDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_float;

static class TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_foo : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_foo() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 154, "test_real_better_one_make_match_regex_word_foo" ) {}
 void runTest() { suite_word_count_test_suite.test_real_better_one_make_match_regex_word_foo(); }
} testDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_foo;

static class TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_space : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_space() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 178, "test_real_better_one_make_match_regex_word_space" ) {}
 void runTest() { suite_word_count_test_suite.test_real_better_one_make_match_regex_word_space(); }
} testDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_space;

static class TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_commant : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_commant() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 187, "test_real_better_one_make_match_regex_word_commant" ) {}
 void runTest() { suite_word_count_test_suite.test_real_better_one_make_match_regex_word_commant(); }
} testDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_commant;

static class TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_none_of_them : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_none_of_them() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 194, "test_real_better_one_make_match_regex_word_none_of_them" ) {}
 void runTest() { suite_word_count_test_suite.test_real_better_one_make_match_regex_word_none_of_them(); }
} testDescription_suite_word_count_test_suite_test_real_better_one_make_match_regex_word_none_of_them;

static class TestDescription_suite_word_count_test_suite_test_word_count_single_word : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_word_count_single_word() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 219, "test_word_count_single_word" ) {}
 void runTest() { suite_word_count_test_suite.test_word_count_single_word(); }
} testDescription_suite_word_count_test_suite_test_word_count_single_word;

static class TestDescription_suite_word_count_test_suite_test_word_count_single_word2 : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_word_count_single_word2() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 223, "test_word_count_single_word2" ) {}
 void runTest() { suite_word_count_test_suite.test_word_count_single_word2(); }
} testDescription_suite_word_count_test_suite_test_word_count_single_word2;

static class TestDescription_suite_word_count_test_suite_test_word_count_single_int : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_word_count_single_int() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 227, "test_word_count_single_int" ) {}
 void runTest() { suite_word_count_test_suite.test_word_count_single_int(); }
} testDescription_suite_word_count_test_suite_test_word_count_single_int;

static class TestDescription_suite_word_count_test_suite_test_word_count_single_float : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_word_count_single_float() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 231, "test_word_count_single_float" ) {}
 void runTest() { suite_word_count_test_suite.test_word_count_single_float(); }
} testDescription_suite_word_count_test_suite_test_word_count_single_float;

static class TestDescription_suite_word_count_test_suite_test_word_count_single_foo : public CxxTest::RealTestDescription {
public:
 TestDescription_suite_word_count_test_suite_test_word_count_single_foo() : CxxTest::RealTestDescription( Tests_word_count_test_suite, suiteDescription_word_count_test_suite, 235, "test_word_count_single_foo" ) {}
 void runTest() { suite_word_count_test_suite.test_word_count_single_foo(); }
} testDescription_suite_word_count_test_suite_test_word_count_single_foo;

#include <cxxtest/Root.cpp>
const char* CxxTest::RealWorldDescription::_worldName = "cxxtest";
