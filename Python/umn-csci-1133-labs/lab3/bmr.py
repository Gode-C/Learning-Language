w = float(input('Enter the weight in pounds'))
h = float(input('Enter the height in inches'))
a = float(input('Enter the age in years'))
g = input('Enter the gender')
if g == 'male':
    bmr = 655 + 4.3 * w + 4.7 * h - 4.7 * a
elif g == 'female':
    bmr = 66 + 6.3 * w + 12.9 * h - 6.8 * a
print('BMR =',bmr)
