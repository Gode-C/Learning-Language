
##Cyrus Chen

all : word_count run_tests

# word_count
word_count : main.o read_input.o regex.o word_count.o
	g++ -o word_count main.o regex.o read_input.o word_count.o -I.

main.o : src/main.cc
	g++ -c src/main.cc -I.

regex.o : src/regex.cc include/regex.h
	g++ -c src/regex.cc include/regex.h -I.
		
read_input.o : src/read_input.cc include/read_input.h
	g++ -c src/read_input.cc include/read_input.h -I.		

word_count.o : src/word_count.cc include/word_count.h
	g++ -c src/word_count.cc include/word_count.h -I.
		
# run_tests
run_tests : src/word_count.cc src/regex.cc include/word_count.h include/regex.h

#make tests
	cxxtest/bin/cxxtestgen \
	--error-printer --abort-on-fail --have-eh \
	-o word_count_tests.cc tests/word_count_tests.h
	g++ -Wall -I. -Icxxtest -o word_count_test word_count_tests.cc src/word_count.cc src/regex.cc
	
#run	
	./word_count_test

# clean
clean :
		rm -f *.o word_count run_tests
