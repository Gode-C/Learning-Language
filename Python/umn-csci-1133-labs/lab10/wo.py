keywords = [ 'False', 'None', 'True', 'and', 'as', 'assert', 'break', 'class',
             'continue', 'def', 'del', 'elif', 'else', 'except', 'finally',
             'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda',
             'nonlocal', 'not', 'or', 'pass', 'raise', 'return', 'try',
             'while', 'with', 'yield' ]
ifile = open(input('enter the name of the file'),'r')

nkk = dict()
for i in keywords:
    nkk[i]=0
for line in ifile:
    a = line
    for i in a:
        if i.isalpha()==False:
            a = a.replace(i,' ')
    a = a.split()
    for i in a:
        if i in keywords == True:
            nkk[i] = nkk[i] + 1
            
for i in keywords:
    if nkk[i]==0:
        del nkk[i]

a = nkk.keys()
a=sorted(a)
ifile.close()
for i in a:

    print(i,'\t',nkk[i])
