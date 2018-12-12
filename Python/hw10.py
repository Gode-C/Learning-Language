class ImpMeas(object):
    def __init__(self,x = '0"'):
        x = x.replace(' ','')
        if "'" in x and '"' in x:
            x = x.split("'")
            a = x[0]
            b = x[1].replace('"','')
            self.inch = int(a) * 12 + int(b)
        elif "'" in x and '"' not in x:
            x = x.replace("'",'')
            self.inch = int(x)*12
        elif "'" not in x and '"' in x:
            x = x.replace('"','')
            self.inch = int(x)
        elif "'" not in x and '"' not in x:
            self.inch = 0
    def __str__(self):
        a = 0
        b = self.inch
        while b >= 12:
            b -= 12
            a += 1
        while b < 0:
            b += 12
            a -= 1
        return str(a)+"'"+str(b)+'"'
    def __repr__(self):
        return self.__str__()
    def __add__(a,b):
        c = str(a.inch + b.inch)+'"'
        c = ImpMeas(c)
        return c
    def __sub__(a,b):
        c = abs(a.inch - b.inch)
        c = ImpMeas(str(c)+'"')
        return c
    def __mul__(a,b):
        c = a.inch * b
        c = ImpMeas(str(c)+'"')
        return c
    def __truediv__(a,b):
        c = a.inch // b
        c = ImpMeas(str(c)+'"')
        return c
    def __mod__(a,b):
        c = a.inch % b
        c = ImpMeas(str(c)+'"')
        return c
    
    
        
