k = float(input("Enter the amount of Dollars"))
d = float(input("Enter the amount of Cents"))
x = int(k * 100 + d)
q = int(x) // 25
di = int(x - 25 * q) // 10
ni = int(x - 25 * q - 10 * di) // 5
p = int(x  - 25 * q - 10 * di - 5 * ni)
print(q,"quarters")
print(di,"dimes")
print(ni,"nickles")
print(p,"pennies")

