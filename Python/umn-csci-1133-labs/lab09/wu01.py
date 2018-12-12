import random
filett = open(input('enter filename'),'w')
for i in range(1,1001):
    filett.write(str(i)+','+str(random.randint(-1000,1000))+'\n')
filett.close()
