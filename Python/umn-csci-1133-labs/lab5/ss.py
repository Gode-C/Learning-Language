m = list()

n = int(input('input something'))
import random
s1 = list(range(n))
random.shuffle(s1)
k = len(s1)
print(s1)
i = 1
while i <= k:
    
    q = min(s1)
    
    p = s1.index(min(s1))
    
    del s1[p]
    
    m += [q]
    
    i += 1

print(m)
