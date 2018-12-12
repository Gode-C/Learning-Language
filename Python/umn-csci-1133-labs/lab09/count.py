ffile = open(input('entername'),'r')
l = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
for line in ffile:
    for ch in line:
        if ch in 'qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM':           
            ch = ch.lower()
            l[ord(ch)-97]+=1
print(l)
print(chr((l.index(max(l)))+97))

            
