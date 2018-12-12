from tkinter import *
def Cacl():
    a=len(enta.get())-len(entb.get())
    a=a**4
    if a > 100:
        a = 100
    labe['text'] = str(a)
aww=Tk()

aww.geometry("300x400")
aww.title("Love Calculator")
enta = Entry(aww, width=10)
enta.place(x=50,y=250)
entb = Entry(aww, width=10)
entb.place(x=150,y=250)
button=Button(aww,text="Compare",command=Cacl)
labe=Label(aww,text="")
button.place(x=100,y=300)
labe.place(x=150,y=100)
labq=Label(aww,text="Name 1")
labq.place(x=50,y=230)
labw=Label(aww,text="Name 2")
labw.place(x=150,y=230)
laby=Label(aww,text='Should You Be Together?')
laby.place(x=75,y=85)
aww.mainloop()
