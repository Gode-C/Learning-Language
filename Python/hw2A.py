a = float(input('Enter current account balance:'))
if a < 0:
    print('Invalid account balance')
else:
    if a < 1000:
        i = a * 0.015
    else:
        i = 1000 * 0.015 + (a - 1000) * 0.01
    ta = a + i
    if ta < 10:
        m = ta
    else:
        if 0.1 * ta < 10:
            m = 10
        else:
            m = 0.1 * ta
format(i, '.2f')
format(ta, '.2f')
format(m, '.2f')
print('Interest:', format(i, '.2f'))
print('Amount Due', format(ta, '.2f'))
print('Minimum Payment:', format(m, '.2f'))
