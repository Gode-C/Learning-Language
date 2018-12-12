#!/bin/bash

g++ -I. src/*.cc -c
g++ -oword_count main.o word_count.o regex.o read_input.o
