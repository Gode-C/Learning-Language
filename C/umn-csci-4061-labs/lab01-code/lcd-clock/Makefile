CFLAGS = -Wall -g
CC     = gcc $(CFLAGS)

clock_sim : lcd_clock.o lcd_clock_main.o lcd_update.o lcd_clock.h
	$(CC) -o clock_sim lcd_clock.o lcd_clock.h lcd_clock_main.o lcd_update.o

lcd_clock_main.o : lcd_clock_main.c lcd_clock.h
	$(CC) -c lcd_clock_main.c

lcd_clock.o : lcd_clock.c lcd_clock.h
	$(CC) -c lcd_clock.c

lcd_update.o : lcd_update.c lcd_clock.h
	$(CC) -c lcd_update.c

test : lcd_tests
	./lcd_tests

lcd_tests : lcd_tests.o lcd_clock.o lcd_update.o lcd_clock.h
	$(CC) -o lcd_tests lcd_tests.o lcd_clock.o lcd_update.o lcd_clock.h

lcd_tests.o : lcd_tests.c lcd_clock.h
	$(CC) -c lcd_tests.c

clean:

	rm -f *.o

clean_all: 

	rm -f *.o clock_sim lcd_tests
