i = 0
ma = 0
mi = 100
su = 0
p = 0
m = 1
k = 0
s = list()
while m >= 0:
    m = int(input('Enter a score'))
    if m <= 100 and m > 0 :
        s +=  [m]
    elif m > 100:
        print('Invalid score... re-enter')
while i < len(s):
    if s[i] > ma:
        ma = s[i]
        if s[i] < mi:
            mi = s[i]       
    elif s[i] < mi:
        mi = s[i]
    su += s[i]
    i = i + 1
su = su / len(s)
while p < len(s):
    k += (s[p] - su) ** 2
    p += 1
k = k / len(s)
kk = 1
while abs(kk * kk - k) > 0.00001:
    kk = (kk + k / kk) / 2


print('Number of scores:',len(s))
print('Maximun score:', ma)
print('Minimun score:', mi)
print('Average score score:',su)
print('Standaed dev:',"%.2f" % kk)
