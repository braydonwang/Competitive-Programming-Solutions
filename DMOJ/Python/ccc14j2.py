a = 0
b = 0

numberOfVotes = int(input())
votes = raw_input()

for letter in votes:
    if letter == "A":
        a = a + 1
    else:
        b = b + 1

if a > b:
    print "A"
elif b > a:
    print "B"
else:
    print "Tie"
