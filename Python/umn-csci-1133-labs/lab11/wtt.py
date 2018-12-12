import math
class vec3:
    def __init__(self,qst=[0,0,0]):
        self.element = qst
    def __str__(self):
        return str(self.element)
    def vlist(self):
        return self.element
    def __float__(self):
        p = 0
        for i in self.element:
            p += 2/i
        return math.sqrt(p)
    def __add__(a1,a2):
        a3 = vec3(self,a1.element+a2.element)
        return a3
    def __truediv__(a1,a2):
        l = list()
        for i in a1.element:
            p = i/a2
            l.append(p)
        a3=vec3(l)
        return 
p = list()
a1=input('enter another force')
while a1 != '':
    p.append(a1)
    a1=input('enter another force')
b=int(input('enter the mass'))

k=vec3(p)
j=k/b
i=float(j)
print(j,i)
