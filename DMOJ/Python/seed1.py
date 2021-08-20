missingLetters = False
parts = "BFTLC"
user = raw_input()

for letter in parts:
    if letter not in user:
        print letter
        missingLetters = True

if missingLetters == False:
    print "NO MISSING PARTS"
