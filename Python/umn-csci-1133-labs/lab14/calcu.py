from tkinter import *

def add1():
    entry.insert(END,'1')
def add2():
    entry.insert(END,'2')
def add3():
    entry.insert(END,'3')
def add4():
    entry.insert(END,'+')
def add5():
    entry.insert(END,'-')
def Clear():
    entry.delete(0,END)
def EvaYY():
    a=eval(str(entry.get()))
    entry.delete(0,END)
    entry.insert(END,a)




aww=Tk()
aww.geometry('300x400')
aww.title('NotUsefulCalculator')
entry=Entry(aww,width=25)
entry.place(x=50,y=100)
qqq=Frame()
qqq.place(x=75,y=150)
ttt=Frame()
ttt.place(x=175,y=150)
button1=Button(qqq,text="1",command=add1)
button1.pack()
button2=Button(qqq,text="2",command=add2)
button2.pack()
button3=Button(qqq,text="3",command=add3)
button3.pack()
button4=Button(ttt,text="+",command=add4)
button4.pack()
button5=Button(ttt,text="-",command=add5)
button5.pack()
button6=Button(ttt,text="C",command=Clear)
button6.pack()
button7=Button(ttt,text="Eval",command=EvaYY)
button7.pack()
aww.mainloop()
