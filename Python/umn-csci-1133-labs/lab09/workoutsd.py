ffile = open('2.5_day.csv','r')
line = ffile.readline()
a=line.split(',')
for i in a:
    print(a.index(i),i)

