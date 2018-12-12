print('You can go first.')
t = 0
p = 21
while p > 3:
    h = int(input("how much you want to remove?"))
    p = p - h
    if p > 3:
    
        print('OK, I will take 1.')
        p = p-1
        print(p,'objects remain, chose 1,2 or 3:')
    else:
        t = 1
        print('only',p,'left, I win.')
if t == 0:
    print('Wait, You Win!')

