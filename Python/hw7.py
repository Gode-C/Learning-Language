import random

def encryptMsg(x,key,a):
    p = ''
    x = x.lower()
    x = list(x)
    m = len(x)-1
    while m > 0:
        if x[m] not in a:
            del x[m]
        m = m - 1  
    for i in x:
        q = a.find(i)
        p += key[q]
    return p

def decryptMsg(c,key,a):
    p = ''
    for i in c:
        q = key.find(i)
        p += a[q]
    return p

def makeKey(a):
    key = list(a)
    random.shuffle(key)
    key = ''.join(key)
    return key

