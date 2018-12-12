def digitsum(n):
    n = abs(n)
    if n < 10:
        return n
    else:
        return (n % 10) + digitsum(n // 10)
def digitalroot(n):
    n = abs(n)
    if n < 10:
        return n
    else:
        return digitalroot(digitsum(n))
