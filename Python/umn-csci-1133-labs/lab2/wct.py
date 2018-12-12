t = int(input("Enter the Temperature in Fahreheit -58~41"))
v = int(input("Enter the wind velocity"))
w = 35.74 + 0.6215 * t - 35.75 * (v ** 0.16) + 0.4275 * t * (v ** 0.16)
print(w)
 
