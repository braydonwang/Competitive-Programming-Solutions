count = 0
x = int(input())
m = int(input())

while count <= m:
    if (count * x) % m == 1:
        inverse = count
        break
    count = count + 1

if count > m:
    print "No such integer exists."
else:
    print inverse
