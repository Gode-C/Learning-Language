q = input('enter something')
c = 0
t = list()
while q != '':

    if q[0].lower() in q[1:].lower():
        t += [q]
    q = input('enter something')



i = 0
while i < len(t):

    print(t[i])

    i +=1
    
