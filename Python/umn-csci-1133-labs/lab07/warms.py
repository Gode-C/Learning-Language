def rev(n):
    n = int(n)
    q = 0

    
    if n == 0:
        return 0
    else:
        p  = rev(n // 10)
        q = n % 10 + q + p * 10


x = input('input something')
print(rev(x))
