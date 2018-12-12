x = float(input('Enter X'))
y = float(input('Enter Y'))
z = float(input('Enter Z'))
if x > y:
    if x > z:
        print('X',x,'is the largest number')
    elif x == z:
        print('X and Z',x,'are the largest numbers')
    else:
        print('Z',z,'is the largest number')
elif x == y:
    if x > z:
        print('X and Y',x,'are the largest numbers')
    elif x == z:
        print('X, Y and Z',x,'are the same numbers')
    else:
        print('Z',z,'is the largest number')
else:
    if y > z:
        print('Y',y,'is the largest number')
    elif y == z:
        print('Y and Z',y,'are the largest numbers')
    else:
        print('Z',z,'is the largest number')
