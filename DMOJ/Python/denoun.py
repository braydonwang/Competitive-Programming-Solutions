linesOfGerman = input()

for i in range(linesOfGerman):
    noun = 0
    line = raw_input()
    for letter in line:
        if ord(letter) >= 65 and ord(letter) <= 90:
            noun = noun + 1
    print noun
