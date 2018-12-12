w = int(input("enter the number"))
p = w // 1000
q = (w - 1000 * p) // 100
o = (w - 1000 * p - 100 * q) // 10
t = (w - 1000 * p - 100 * q - 10 * o) // 1
print(t, o, q, p)
