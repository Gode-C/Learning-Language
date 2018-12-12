from tkinter import *

def changeText():
    greetings['text'] = "Hello, "+nameEntry.get()

    
win = Tk()
win.geometry("400x400")
win.title("Super Fun Project")

greetings = Label(win,text="Hello World",font=("Helvetica",30))
greetings.place(x=50,y=100)
testButton = Button(win,text="Click Me", command=changeText)
testButton.place(x=300,y=300)
nameEntry = Entry(win, width=25)
nameEntry.place(x=30,y=300)




win.mainloop()
