import random

mylist = [0] * 10000
mylist1 = list(range(1,7))
random.shuffle(mylist1)
mylist2 = list(range(1,7))
random.shuffle(mylist2)
mylist = mylist1 + mylist2
