import random
count = 100000
yes = 0
no = 0
while count > 0:
    
    x = random.uniform(-1,1)
    y = random.uniform(-1,1)
    if (x * x + y * y) < 1:
        yes = yes +1
        count = count - 1
    else:
        no = no + 1
        count = count - 1
q = yes / 100000 * 4
print(q)
        
