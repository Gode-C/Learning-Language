def rew(x):
    p = []
    q = list(x)
    i = len(q)-1
    while i >= 0:
        p.append(q[i])
        i = i - 1
    t=''.join(p)
    return t
print(rew(input()))
