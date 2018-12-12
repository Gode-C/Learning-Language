def ltrcount(x):
    p = len(x)
    v = x.count('1')
    v += x.count('2')
    v += x.count('3')
    v += x.count('4')
    v += x.count('5')
    v += x.count('6')
    v += x.count('7')
    v += x.count('8')
    v += x.count('9')
    v += x.count('0')
    p = p-v
    return p
        
print(ltrcount(input()))
