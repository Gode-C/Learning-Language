import turtle

n = int(input('enter ther number of squares'))
k = (360 / n)
x = turtle.Turtle()
x.speed(0)


def ds(x,y):

    for i in range(0,4):
       
        x.forward(y)
        x.right(90)


for t in range(0,n):
        
    ds(x,100)
    x.left(k)

