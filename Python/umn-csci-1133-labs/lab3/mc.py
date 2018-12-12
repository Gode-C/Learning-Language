v =float(input("Enter the Value"))
n = input("Enter the units")
if n == 'pounds':
    x = v * 0.4535
    print(x, 'kilos')
elif n == 'kilos':
    x = v * 2.20462
    print(x, 'pounds')
elif n == 'ounces':
    x = v * 28.35
    print(x, 'grams')
elif n == 'grams':
    x = v / 28.35
    print(x, 'ounces')
elif n == 'miles':
    x = v * 1.61
    print(x, 'kilometers')
elif n == 'kilometers':
    x = v / 1.61
    print(x, 'miles')
elif n == 'centimeters':
    x = v / 2.54
    print(x, 'inches')
elif n == 'centimeters':
    x = v * 2.54
    print(x, 'inches')
else:
    print(v,n,'?')


