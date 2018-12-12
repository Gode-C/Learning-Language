import time
w = time.time()
q = w % 86400
h = q // 3600
p = w % 3600
m = p // 60
print(h, m)
