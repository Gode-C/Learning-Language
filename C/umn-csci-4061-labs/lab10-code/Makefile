CFLAGS = -Wall -g
CC     = gcc $(CFLAGS)

all : philosophers_ipc philosophers_pthread

philosophers_ipc : philosophers_ipc.c
	$(CC) -o $@ $^

# **CHANGE** to include compilation of the philosophers_pthread program

philosophers_pthread: philosophers_pthread.c
	$(CC) -o $@ $^ -lpthread

clean :
	rm -f *.o philosophers_ipc  philosophers_pthread



