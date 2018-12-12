m = list(input('enter the cards'))
t = 0
i = 0


for w in m:
    if w in '23456789':
        w = int(w)
        t = w + t
    elif w in 'tjqkTJQK':
        w = 10
        t = w + t
    elif w in 'aA':
        w = 1
        i += 1
        t = w + t


while i > 0:
    if t + 10 <= 21:
        t += 10
    else:
        i = 0
print(t)
