letters = []
happy = 0
sad = 0
sentence = raw_input()

for letter in sentence:
    letters.append(letter)

for i in range(len(letters)):
    if letters[i] == ":" and letters[i + 1] == "-":
        if letters[i+2] == ")":
            happy = happy + 1
        elif letters[i+2] == "(":
            sad = sad + 1

if happy == 0 and sad == 0:
    print "none"
elif happy == sad:
    print "unsure"
elif happy > sad:
    print "happy"
elif sad > happy:
    print "sad"
