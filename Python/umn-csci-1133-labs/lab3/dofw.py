p = int(input('Enter month'))
d = int(input('Enter day'))
q = int(input('Enter year'))

if p == 1 or p == 2:
    m = p + 12
    y = q - 1
else:
    m = p
    y = q
    


i = (26 * (m + 1)) // 10
j = (5 * (y % 100)) // 4
k = (21 * (y // 100)) // 4

x = int(d + 5 + i + j + k)


n = x % 7
if n == 0:
    print(p,'/',d,'/',q,'is a Monday')
elif n == 1:
    print(p,'/',d,'/',q,'is a Tuesday')
elif n == 2:
    print(p,'/',d,'/',q,'is a Wednsday')
elif n == 3:
    print(p,'/',d,'/',q,'is a Thursday')
elif n == 4:
    print(p,'/',d,'/',q,'is a Friday')
elif n == 5:
    print(p,'/',d,'/',q,'is a Saturday')
elif n == 6:
    print(p,'/',d,'/',q,'is a Sunday') 
