n = input()
a = []
b = []
for i in range(n):
    x = raw_input()
    a.append(x)
for i in range(n-1):
    y = raw_input()
    b.append(y)
a.sort()
b.sort()
for x,y in zip(a, b):
    if x != y:
        print x
        break;
else:
    print a[-1]
