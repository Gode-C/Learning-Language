class measure:
    def __init__(self,f=0,i=0):
        self.feet = f
        self.inches = i
        while self.inches >= 12:
            self.feet +=1
            self.inches -=12
        while self.inches < 0:
            self.feet -=1
            self.inches+=12
    def __str__(self):
        if self.feet == 0:
            return str(self.inches)+'"'
        if self.inches == 0 and self.feet != 0:
            return str(self.feet)+"'"
        else:
            return str(self.feet)+"'"+str(self.inches)+'"'
    def __repr__(self):
        return self.__str__()
    def __add__(a1,a2):
        a3 = measure(a1.feet+a2.feet,a1.inches+a2.inches)
        return a3
    def __sub__(a1,a2):
            a3 = measure(a1.feet-a2.feet,a1.inches-a2.inches)
            return a3


m1=measure()
m2=measure(4,11)
m3=measure(6,10)
print(m1)
print(m2+m3)
print(m3-m2)
