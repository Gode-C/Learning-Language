nuk = {'a':2,'b':2,'c':3,'d':3,'e':3,'f':3,'g':4,'h':4,'i':4,'j':5,'k':5,'l':5,'m':6,'n':6,'o':6,'p':7,'q':7,'r':7,'s':7,'t':8,'u':8,'v':8,'w':9,'x':9,'y':9,'z':9}
pn = input('enter the phone number')
while pn != '':
    pn = pn.lower()
    pnr = ''
    k = ''
    m = ''
    a = ''
    for i in pn:
        if i.isalnum() == True:
            pnr+=i
    if len(pnr)==10 or len(pnr)==7:
        for i in pnr:
            if i.isalpha() == True:
                k+=str(nuk[i])
            elif i.isdigit() == True:
                k+=i
        if len(k) == 7:
            m = k[0],k[1],k[2],'-',k[3],k[4],k[5],k[6]
        if len(k) == 10:
            m = k[0],k[1],k[2],'-',k[3],k[4],k[5],'-',k[6],k[7],k[8],k[9]
        for i in m:
            a+=i
        print('Numeric telephone number is:',a)           
        pn = input('enter the phone number')
    else:
        print('Invalid number')
        pn = input('enter the phone number')
