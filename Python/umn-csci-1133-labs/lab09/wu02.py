ffile = open(input('rnter file name'),'r')
maxt = -9999
mint = 9999
for line in ffile:
    a = line.split(',')
    if int(a[1]) > int(maxt):
        maxt = a[1]
    if int(a[1]) < int(mint):
        mint = a[1]
print(maxt,mint)
