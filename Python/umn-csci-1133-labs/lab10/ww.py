def makeDitionary(a,b):
    d = dict()
    for i in a:
        d[i]=b[a.index(i)]
    return d

names = ['joe', 'tom', 'barb', 'sue', 'sally']
scores = [10,23,13,18,12]

scoreDict=makeDitionary(names,scores)


def getScore(n,d):
    if n in d:
        
        return d[n]
    else:
        print('name not found')
        return -1
