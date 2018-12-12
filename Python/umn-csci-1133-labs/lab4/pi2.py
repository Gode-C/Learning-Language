import math
n = math.sqrt(3)
t = float(input('Enter a tolerance'))
u = 1 - 1 / 3 * 3
count = 1
while count < 10:
    if count % 2 == 0:
        u = u - 1 / (3 ** count * 3 + count * 2)
        p = 6 / n  * u
        count + 1
    else:
        u = u + 1 / (3 ** count * 3 + count * 2)
        p = 6 / n * u
        count + 1
print(n,p)
