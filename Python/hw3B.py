
a = int(input('Enter the upper bound:'))

if a > 1:
    print('Perfect numbers in the interval [ 0,',a,']:')
    x = 2
    while x <= a:
        t = 0
        i = 1
        while i < x:
            if x % i == 0:
                t += i
                i += 1
            else:
                i += 1
        if t == x:
            print(x)
        x += 1
else:
    print('Invalid upper bound!')
