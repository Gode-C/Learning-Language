class Vehicle():
    def __init__(self,mk=None,md=None,yr=None,ma=None,pr=None):
        self.mk = mk
        self.md = md
        self.yr = yr
        self.ma = ma
        self.pr = pr
    def getMake(self):
        return str(self.mk)
    def setMake(self,x):
        self.mk = x
    def getModel(self):
        return str(self.md)
    def setModel(self,x):
        self.md = x
    def getYear(self):
        return str(self.yr)
    def setYear(self,x):
        self.yr = x 
    def getMileage(self):
        return str(self.ma)
    def setMileage(self,x):
        self.ma = x
    def getPrice(self):
        return str(self.pr)
    def setPrice(self,x):
        self.pr = x
    def Display(self):
        print('Make: ',str(self.mk))
        print('Year: ',str(self.yr))
        print('Model:',str(self.md))
        print('Miles:',str(self.ma))
        print('Price:',str(self.pr))
class Car(Vehicle):
    def __init__(self,mk,md,yr,ma,pr,nd):
        super().__init__(mk,md,yr,ma,pr)
        self.nd = nd
    def getDoor(self):
        return str(self.nd)
    def setDoor(self,x):
        self.nd = x
    def Display(self):
        print('Inventory unit: Car')
        super().Display()
        print('Number of Doors:',str(self.nd))
class Truck(Vehicle):
    def __init__(self,mk,md,yr,ma,pr,dt):
        super().__init__(mk,md,yr,ma,pr)
        self.dt = dt
    def getDrivetpye(self):
        return str(self.dt)
    def setDrivetype(self,x):
        self.dt = x
    def Display(self):
        print('Inventory unit: Truck')
        super().Display()
        print('Drive type:',str(self.dt))
class SUV(Vehicle):
    def __init__(self,mk,md,yr,ma,pr,pc):
        super().__init__(mk,md,yr,ma,pr)
        self.pc = pc
    def getPassengerCap(self):
        return str(self.pc)
    def setPassengerCap(self,x):
        self.pc = x
    def Display(self):
        print('Inventory unit: SUV')
        super().Display()
        print('Passenger Capacity:',str(self.pc))
class Inventory():
    def __init__(self):
        self.thelist = list()
    def addVehicle(self,x):
        self.thelist += [x]
    def Display(self):
        m = len(self.thelist)
        for i in self.thelist:
            i.Display()
            m -= 1
            if m > 0:
                print('\n')
def main():
    l = Inventory()
    x = input('Enter the car type')
    while x != '':
        if x == 'Car':
            a = Car(input('enter the brand'),input('enter the year'),input('enter the model'),
                    input('enter the mileage'),input('enter the price'),
                    input('enter the number of doors'))
            l.addVehicle(a)
        elif x == 'Truck':
            a = Truck(input('enter the brand'),input('enter the year'),input('enter the model'),
                    input('enter the mileage'),input('enter the price'),
                    input('enter the drive type'))
            l.addVehicle(a)
        elif x == 'SUV':
            a = SUV(input('enter the brand'),input('enter the year'),input('enter the model'),
                    input('enter the mileage'),input('enter the price'),
                    input('enter the passenger capacity'))
            l.addVehicle(a)
        else:
            print('No Vehicle find, please try again.')
        x = input('Enter the car type, press Enter key with tpye anything when done')
    l.Display()
