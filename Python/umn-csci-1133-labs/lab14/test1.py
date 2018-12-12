from tkinter import *
win = Tk()
win.geometry("400x200")
def addX():
    eqn.insert(END,"X")
def clear():
    eqn.delete(0,END)
button1 = Button(win, text="Add X", command=addX)
button1.place(x=30,y=150)
buttonClear = Button(win, text="C", command=clear)
buttonClear.place(x=270,y=150)
eqn = Entry(win, width=25)
eqn.place(x=30,y=30)
mainloop()
