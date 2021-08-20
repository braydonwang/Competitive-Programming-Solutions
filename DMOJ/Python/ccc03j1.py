t = int(input())
s = int(input())
h = int(input())
line = ""

for i in range(t):
    print "*" + " "*s + "*" + " "*s + "*"
print "*"*(3 + 2*s)

for n in range(h):
    line = " "*((3+2*s)/2) + "*"
    print line
