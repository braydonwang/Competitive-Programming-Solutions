code = []
N = input()

for i in range(N):
    a,b = map(str,raw_input().split())
    a = int(a)
    x = b*a
    code.append(x)

for i in range(len(code)):
    print code[i]
