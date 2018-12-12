# Tom Postler, 2015-04-01
# Test input file

import random
import turtle

def randColor():
    colors = ["red", "yellow", "green", "blue", "purple", "orange"]
    return colors[random.randint(0,5)]

class Shape():
    def __init__(self, x=0, y=0, fcolor='', filled=False):
        self.x = x
        self.y = y
        self.fcolor = fcolor
        self.filled = filled

    def setFillColor(self, s):
        self.fcolor = s

    def setFilled(self, c):
        self.filled = c

    def isFilled(self):
        return self.filled

class Circle(Shape):
    def __init__(self, x=0, y=0, r=1, fcolor='', filled=False):
        super().__init__(x,y,fcolor,filled )
        self.r = r

    def draw(self, t):
        t.penup()
        t.goto(self.x, self.y)
        t.pendown()
        if self.filled == True:
            t.fillcolor(self.fcolor)
            t.begin_fill()
            t.circle(self.r)
            t.end_fill()
        else:
            t.circle(self.r)

class Display():
    def __init__(self):
        self.t = turtle.Turtle()
        self.scr = turtle.Screen()
        self.elements = []
        
        self.scr.delay(0)
        self.t.speed(0)
        self.t.hideturtle()

r = 0
d = Display()
d.t.penup()
d.t.goto(-920,-441)
d.t.pendown()

for i in range(0,500):
    c = Circle(d.t.xcor(), d.t.ycor(), r, 'white', True)
    c.draw(d.t)
    d.t.right(10)
    d.t.penup()
    d.t.goto(d.t.xcor()+3,d.t.ycor()+1)
    d.t.pendown()
    r+=.1
