strong = 0
n = input()
ren = input()

for i in range(n-1):
    others = input()
    if others >= ren:
        strong = 1

if strong == 0:
    print "YES"
else:
    print "NO"
