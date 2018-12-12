import os.path
a = ''
print('Airport Routing Filter')
t = input('Enter the source file name')
m = 0
while m != 3:
    if os.path.isfile(t) == False:
        t = input('File not found. Reenter:')
        m = m + 1
    else:
        m = 3
        ifile = open(t,'r')
        e = input('Enter the output file name:')
        if os.path.isfile(e) == True:
            ex = input('File exists... overwrite? (y/n)')
            if ex == 'y':
                x = input('Enter airport symbol:')
                x = x.upper()
                k = ifile.readline()
                while k != '':
                    if x in k:
                        a += k
                    k = ifile.readline()
                ifile.close() 
                efile = open(e,'w')
                efile.write(a)
                efile.close()
                print('Finished')
        else:
            x = input('Enter airport symbol:')
            x = x.upper()
            k = ifile.readline()
            while k != '':
                if x in k:
                    a += k
                k = ifile.readline()
            ifile.close()
            efile = open(e,'w')
            efile.write(a)
            efile.close()
            print('Finished')
