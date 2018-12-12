def fib(n):
    p = 0
    if n ==1:
        return 0
    if n == 2:
        return 1
    else:
        return fib(n - 2) + fib(n - 1)

for i in range(1,21):
    
    print(fib(i))
