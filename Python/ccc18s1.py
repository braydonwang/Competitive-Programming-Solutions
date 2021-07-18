N = input()
minimum = 999999999999
num = []

for i in range(N):
    point = input()
    num.append(point)

num.sort()

for i in range(1,N-1):
    left = 0
    right = 0
    total = 0
    left = (num[i] - num[i-1])/2.0
    right = (num[i+1] - num[i])/2.0
    total = round(left+right,1)
    if total < minimum:
        minimum = total

print minimum
