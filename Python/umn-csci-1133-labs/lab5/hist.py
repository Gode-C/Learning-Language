

import random
time = 0
q = [0] * 11

while time < 10000:
    
    s1 = random.randint(1,6)
    s2 = random.randint(1,6)
    s = s1 + s2
    q[s-2] += 1
    time += 1
print(q)
