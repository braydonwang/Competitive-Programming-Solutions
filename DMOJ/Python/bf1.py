numbers = []
num = input()

for i in range(num):
    n = input()
    numbers.append(n)
    numbers.sort()

for i in range(num):
    print numbers[i]
