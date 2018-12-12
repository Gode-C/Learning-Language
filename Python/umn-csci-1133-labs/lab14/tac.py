from tkinter import *
import random

class Tact():  
    def whatnow(self):
        if self.d % 2 == 0:
            self.d+=1
            return "X"
        else:
            self.d+=1
            return "O"
    def __init__(self):
        self.kk=['']*9
        self.aww=Tk()
        self.aww.title("Tic-tac-toe")
        self.aww.geometry('100x100')
        self.d=random.randint(1,2)
        self.button1=Button(self.aww,text=None,command=self.Changeit1)
        self.button1.place(x=0,y=0)
        self.button2=Button(self.aww,text=None,command=self.Changeit2)
        self.button2.place(x=30,y=0)
        self.button3=Button(self.aww,text=None,command=self.Changeit3)
        self.button3.place(x=60,y=0)
        self.button4=Button(self.aww,text=None,command=self.Changeit4)
        self.button4.place(x=0,y=30)
        self.button5=Button(self.aww,text=None,command=self.Changeit5)
        self.button5.place(x=30,y=30)
        self.button6=Button(self.aww,text=None,command=self.Changeit6)
        self.button6.place(x=60,y=30)
        self.button7=Button(self.aww,text=None,command=self.Changeit7)
        self.button7.place(x=0,y=60)
        self.button8=Button(self.aww,text=None,command=self.Changeit8)
        self.button8.place(x=30,y=60)
        self.button9=Button(self.aww,text=None,command=self.Changeit9)
        self.button9.place(x=60,y=60)
        self.aww.mainloop()
    def Changeit1(self):
        self.button1.config(text=self.whatnow())
        self.kk[0]=self.d
    def Changeit2(self):
        self.button2.config(text=self.whatnow())
        self.kk[1]=self.d
    def Changeit3(self):
        self.button3.config(text=self.whatnow())
        self.kk[2]=self.d
    def Changeit4(self):
        self.button4.config(text=self.whatnow())
        self.kk[3]=self.d
    def Changeit5(self):
        self.button5.config(text=self.whatnow())
        self.kk[4]=self.d
    def Changeit6(self):
        self.button6.config(text=self.whatnow())
        self.kk[5]=self.d
    def Changeit7(self):
        self.button7.config(text=self.whatnow())
        self.kk[6]=self.d
    def Changeit8(self):
        self.button8.config(text=self.whatnow())
        self.kk[7]=self.d
    def Changeit9(self):
        self.button9.config(text=self.whatnow())
        self.kk[8]=self.d
    def Chickit():
        if self.kk[0]==self.kk[1]==self.kk[2]=="O":
            print('O win')
t=Tact()
