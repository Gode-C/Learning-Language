#!/bin/bash

# First make the test code for WordCount - WordCount.cpp
cxxtest/bin/cxxtestgen \
   --error-printer --abort-on-fail --have-eh \
   -o tests/word_count_tests.cc tests/word_count_tests.h
# (Note that we can split a single command over several lines by
#  putting a back slash as the final character -  with no spaces
#  or tabs after it either.)

# Second, compile the code to be tested
g++ -c -I. src/regex.cc
g++ -c -I. src/word_count.cc

# Third, compile and run the test code and code to be tested.
g++ -Wall -I. -Icxxtest -o word_count_tests tests/word_count_tests.cc word_count.o regex.o

# Fourth, run the tests
./word_count_tests
