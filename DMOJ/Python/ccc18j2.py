total = 0
y = []
t = []

N = input()
yesterday = raw_input()
today = raw_input()

for letter in yesterday:
    y.append(letter)

for letter in today:
    t.append(letter)

for i in range(N):
    if y[i] == t[i] and y[i] == "C":
        total = total + 1

print total
