import random
import turtle

def randColor():
    c = ['red','yellow','green','blue','purple','orange']
    return c[random.randint(0,5)]
class shape(object):
    def __init__(self,x=0,y=0,c='',f=False):
        self.x = x
        self.y = y
        self.clr = c
        self.fil = f
    def setFillcolor(self,x):
        self.clr = x
    def setFilled(self,x):
        self.fil = x
    def isFilled(self):
        return self.fil
class circle(shape):
    def __init__(self,x=0,y=0,r=1):
        super().__init__(x,y)
        self.r = r
    def draw(self,mytt):
        mytt.penup()
        mytt.goto(self.x,self.y)
        mytt.pendown()
        if self.fil == True:
            mytt.fillcolor(self.clr)
            mytt.begin_fill()
            mytt.circle(self.r)
            mytt.end_fill()
        else:
            mytt.circle(self.r)
class rectangle(shape):
    def __init__(self,x=0,y=0,w=1,h=1):
        super().__init__(x,y)
        self.w = w
        self.h = h
    def draw(self,mytt):
        mytt.penup()
        mytt.goto(self.x,self.y)
        mytt.pendown()
        if self.fil == True:
            mytt.fillcolor(self.clr)
            mytt.begin_fill()
            mytt.forward(self.w)
            mytt.right(90)
            mytt.forward(self.h)
            mytt.right(90)
            mytt.forward(self.w)
            mytt.right(90)
            mytt.forward(self.h)
            mytt.right(90)
            mytt.end_fill()
        else:
            mytt.circle(self.r)       
            mytt.forward(self.w)
            mytt.right(90)
            mytt.forward(self.h)
            mytt.right(90)
            mytt.forward(self.w)
            mytt.right(90)
            mytt.forward(self.h)
            mytt.right(90)
class Display():
    def __init__(self):
        self.element = list()
        self.mytt = turtle.Turtle()
        mysc = turtle.Screen()
        mysc.delay(0)
        self.mytt.speed(0)
        self.mytt.hideturtle()
        mysc.onclick(self.mouseEvent)
        mysc.listen()
    def addre(self,x=random.randint(-800,800),y=random.randint(-400,400)):
        p = [x,y,random.randint(10,100),random.randint(10,100)]
        self.element += [p]
        p = rectangle(p[0],p[1],p[2],p[3])
        p.setFilled(True)
        m = randColor()
        p.setFillcolor(m)
        p.draw(self.mytt)
        self.element[-1] += [m]
    def addcr(self,x=random.randint(-800,800),y=random.randint(-400,400)):
        p = [x,y,random.randint(10,100)]
        self.element += [p]
        p = circle(p[0],p[1],p[2])
        p.setFilled(True)
        m = randColor()
        p.setFillcolor(m)
        p.draw(self.mytt)
        self.element[-1] += [m]
    def mouseEvent(self,x,y):
        j = 0
        for i in self.element:
            if len(i)==4:
                if (x-i[0])** 2 + (y-(i[1]+i[2]))** 2 <= i[2]**2:
                    jj= self.element.index(i)
                    j=1
            if len(i)==5:
                if x>=i[0] and x<=(i[0]+i[2]):
                    if y >= (i[1]-i[3]) and y <= i[1]:
                        jj = self.element.index(i)
                        j=1
        if j == 0:
            q = random.randint(1,2)
            if q == 1:
                self.addre(x,y)
            else:
                self.addcr(x,y)
        else:
            self.remove(jj)
    def remove(self,x=-1):
        del self.element[x]
        self.mytt.clear()
        for i in self.element:
            if len(i)==4:
                p = circle(i[0],i[1],i[2])
                p.setFilled(True)
                p.setFillcolor(i[3])
                p.draw(self.mytt)
            if len(i)==5:
                p = rectangle(i[0],i[1],i[2],i[3])
                p.setFilled(True)
                p.setFillcolor(i[4])
                p.draw(self.mytt)
l = Display()
        
