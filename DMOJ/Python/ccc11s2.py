studentAns = []
answers = []
n = input()
correct = 0

for i in range(n):
    student = raw_input()
    studentAns.append(student)

for i in range(n):
    ans = raw_input()
    answers.append(ans)

for i in range(n):
    if studentAns[i] == answers[i]:
        correct = correct + 1

print correct
