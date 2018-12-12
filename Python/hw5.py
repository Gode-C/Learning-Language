
def ro(x):

    if x == 'I':
        y = 1
    elif x == 'V':
        y = 5
    elif x == 'X':
        y = 10
    elif x == 'L':
        y = 50
    elif x == 'C':
        y = 100
    elif x == 'D':
        y = 500
    elif x == 'M':
        y = 1000
    return y

def conv(s):
    q = 0
    for f in s:
        q += ro(f)
    i = 0
    while i < len(s)-1:
        if ro(s[i]) < ro(s[i+1]):
            q = q - ro(s[i])*2
        i = i + 1
    return q

x = str(input('Enter a Roman Numeral:'))
while x != '':
    l = 0
    for t in x:
        if t in 'qazwsxedcrfvtgbyhnujmikolpQAZSWEFRTPGBNHYUJKO123456789!@#$%^&*()_+-=[]{}\;:/?`~':
            l = 1
    if l == 1:
        print('Invalued Input')
        x = str(input('Enter a Roman Numeral:'))
    else:
        y = conv(x)
        print('Decimal value:',y)
        x = str(input('Enter a Roman Numeral:'))
