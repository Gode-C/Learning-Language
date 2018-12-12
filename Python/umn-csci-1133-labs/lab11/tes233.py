def numdigits(x):
    if x < 0:
        return numdigits(0-x)
    elif x >= 0 and x < 10:
        return 1
    else:
        return numdigits(x//10)+1
