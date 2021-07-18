marks = []
n = input()
for i in range(n):
    x = input()
    marks.append(x)
    
marks.sort()

if n % 2 != 0:
    print int(marks[n/2])
else:
    print int(round((marks[n/2-1]+marks[n/2])/2.0))
