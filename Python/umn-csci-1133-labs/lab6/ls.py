
n = int(input('enter the number'))
root = int(input('enter the root'))

def lala(n,root):

    x = 1

    while abs(x ** root - n) > 0.001:


        x = 1 / root * ((root - 1) * x + (n / x ** (root - 1)))

    return print(x)


lala(n,root)
