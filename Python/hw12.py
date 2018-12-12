from tkinter import *
import random
class SnakeGUI:
    def __init__(self):
        self.stm = 0
        self.root = Tk()
        self.nowscore=0
        self.foodx=0
        self.foody=0
        self.speed = 500
        self.snakeD=1
        self.snk=[[300,300]]
        self.root.geometry('640x670+450+150')
        self.root.title('Snake Game')
        self.bframe = Frame(self.root,height=30,width=640)
        self.bframe.pack()
        self.mframe = Frame(self.root,height=640,width=640,bg='grey')
        self.mframe.pack()
        self.big = Canvas(self.mframe,width=600,height=600)
        self.big.place(x=20,y=20)
        self.menus()
        self.walls()
        self.bfrset()
        self.root.mainloop()
    def start(self):
        if self.stm == 0:
            self.snake()
            self.Keys()
            self.creatfood()
            self.stm=1
            self.butstart['text']='Pause'
            self.butstart['command']=self.pause
        else:
            self.snk=[[300,300]]
            self.nowscore = 0
            self.snakeD=1
            self.speed=500
    def pause(self):

        self.butstart['command']=self.resume
        self.butstart['text']='Resume'
        self.big.after_cancel(self.afft)
    def resume(self):
        self.butstart['text']='Pause'
        self.butstart['command']=self.pause
        self.snake()
    def snake(self):
        self.big.delete('snb')
        for i in self.snk:
            p=self.BlackSq(i[0],i[1])
        self.snakeMove()
        self.checkcrash()
        self.afft=self.root.after(self.speed,self.snake)
    def creatfood(self):
        self.foodx=int(random.randint(0,29)*20)
        self.foody=int(random.randint(0,29)*20)
        self.apple=self.big.create_oval(self.foodx,self.foody,
                                        self.foodx+20,self.foody+20,
                                        fill='red',tags=('food'))
    def eatfood(self):
        self.big.delete('food')
        self.creatfood()
        self.nowscore+=1
        self.scorelabel2['text']=self.nowscore
        if self.speed > 20:
            self.speed = self.speed - 10
    def BlackSq(self,x,y):
        self.big.create_rectangle(x,y,x+20,y+20,fill='black',tags=('snb'))
    def snakeMove(self):
        m=self.snk[0]
        if self.snakeD==1:
            self.snk.insert(0,[m[0],m[1]-20])
        elif self.snakeD==2:
            self.snk.insert(0,[m[0],m[1]+20])
        elif self.snakeD==3:
            self.snk.insert(0,[m[0]-20,m[1]])
        elif self.snakeD==4:
            self.snk.insert(0,[m[0]+20,m[1]])
        if self.snk[0]== [self.foodx,self.foody]:
            self.eatfood()
        else:
            del self.snk[-1]
    def checkcrash(self):
        ll=0
        for i in self.snk:
            if i == self.snk[0]:
                ll+=1
        if ll > 1:
            self.gameover()
        l=self.snk[0]
        if l[0] < 0 or l[0] > 600:
            self.gameover()
        if l[1] < 0 or l [1] > 600:
            self.gameover()
    def gameover(self):
        box = messagebox.askquestion('Game Over','Your Score is '+str(self.nowscore)+'\nTry again?')
        if box == 'yes':
            self.snk=[[300,300]]
            self.nowscore = 0
            self.snakeD=1
            self.speed=500
        else:
            self.root.destroy()
    def Keys(self):
        self.big.focus_set()
        self.big.bind("<w>", self.changeU)
        self.big.bind('<Up>',self.changeU)
        self.big.bind("<s>", self.changeD)
        self.big.bind('<Down>',self.changeD)
        self.big.bind("<a>", self.changeL)
        self.big.bind('<Left>',self.changeL)
        self.big.bind("<d>", self.changeR)
        self.big.bind('<Right>',self.changeR)
    def changeU(self,event):
        if self.snakeD != 2:
            self.snakeD=1
    def changeD(self,event):
        if self.snakeD != 1:
            self.snakeD=2
    def changeL(self,event):
        if self.snakeD != 4:
            self.snakeD=3
    def changeR(self,event):
        if self.snakeD != 3:
            self.snakeD=4 
    def menus(self):
        menubar = Menu(self.root)
        filemenu = Menu(menubar, tearoff=0)
        filemenu.add_command(label="Start", command=self.start)
        filemenu.add_separator()
        filemenu.add_command(label="Exit", command=self.root.destroy)
        menubar.add_cascade(label="Game", menu=filemenu)
        self.root.config(menu=menubar)
        helpmenu = Menu(menubar, tearoff=0)
        helpmenu.add_command(label='Keys',command=self.start)
        menubar.add_cascade(label='Help',menu=helpmenu)
    def bfrset(self):
        self.butstart=Button(self.bframe,text="Start",bg='yellow',command=self.start)
        butquit=Button(self.bframe,text="Exit",bg='yellow',command=self.root.destroy)
        self.butstart.pack(side=LEFT)
        butquit.pack(side=LEFT)
        p = Canvas(self.bframe,height=10,width=40)
        p.pack(side=LEFT)
        p.create_rectangle(40,20,0,0, outline='grey')
        scorelabel=Label(self.bframe,text="Score=")
        self.scorelabel2=Label(self.bframe,text=self.nowscore,fg='blue')
        self.scorelabel2.pack(side=RIGHT)
        scorelabel.pack(side=RIGHT)
    def walls(self):
        w = Canvas(self.mframe, width=620, height=20)
        w.place(x=0,y=0)
        w.create_rectangle(0,0, 620, 20, fill="red", outline = 'red')
        ww = Canvas(self.mframe, width=20, height=620)
        ww.place(x=620,y=0)
        ww.create_rectangle(0,0, 20, 620, fill="red", outline = 'red')
        wq = Canvas(self.mframe, width=20, height=620)
        wq.place(x=0,y=20)
        wq.create_rectangle(0,0,20, 620, fill="red", outline = 'red')
        we = Canvas(self.mframe, width=620, height=20)
        we.place(x=20,y=620)
        we.create_rectangle(0,0, 620,20, fill="red", outline = 'red')
