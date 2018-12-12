
import random
import turtle
def tree(t, trunkLength):
    x = random.randint(15,45)
    y = random.randint(12,18)
    if trunkLength < 5:
        return
    else:
        t.forward(trunkLength)
        t.right(x)
        tree(t, trunkLength - y)
        t.left(x*2)
        tree(t, trunkLength - y)
        t.right(x)
        t.backward(trunkLength)

t = turtle.Turtle()
t.speed(0)
tree(t,120)
