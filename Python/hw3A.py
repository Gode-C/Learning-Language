t = str()
m = 0
num = int(input('Enter an integer value:'))
if num < 0:
    print('Input must be greater or equal to zero!')
else:
    while num > 1:
        p = int(num % 2)
        num = int((num - p) / 2)
        t = str(p) + t
    t = str(num) + t
print(t)
