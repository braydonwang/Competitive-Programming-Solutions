english = 0
french = 0
N = input()

for i in range(N):
    sentence = raw_input()
    for letter in sentence:
        if letter == "t" or letter == "T":
            english = english + 1
        elif letter == "s" or letter == "S":
            french = french + 1

if english > french:
    print "English"
else:
    print "French"
