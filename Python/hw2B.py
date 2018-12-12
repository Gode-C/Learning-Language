a = input('Enter first string:')
b = input('Enter first string:')
c = input('Enter first string:')
if a > b and b > c:
    print(c)
    print(b)
    print(a)
elif a > c and c > b:
    print(b)
    print(c)
    print(a)
elif c > b and b > a:
    print(a)
    print(b)
    print(c)
elif c > b and a > b:
    print(b)
    print(a)
    print(c)
elif b > c and c > a:
    print(a)
    print(c)
    print(b)
elif b > a and a > c:
    print(c)
    print(a)
    print(b)
