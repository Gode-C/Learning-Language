def choose(n,k):
    if k == 0:
        return 1
    elif n == 0:
        return 1
    else:
        return choose(n-1,k-1)+choose(n-1,k)
a = int(input('input n'))
b = int(input('input k'))
print(choose(a,b))
