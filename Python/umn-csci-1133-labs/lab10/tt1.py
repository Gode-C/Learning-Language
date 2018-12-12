ifile = 'if,or,sfefemfkwelmfle'


a = ifile
for i in a:
    if i.isalpha()==False:
        a = a.replace(i,' ')
a = a.split()


