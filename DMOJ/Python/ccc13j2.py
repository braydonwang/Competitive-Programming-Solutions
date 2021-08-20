n = True
rotation = "IOSHZXN"

word = raw_input()
for letter in word:
    if letter not in rotation:
        n = False

if n == True:
    print "YES"
else:
    print "NO"
