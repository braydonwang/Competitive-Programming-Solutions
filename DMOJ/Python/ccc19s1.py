a = 0
b = 0
three = input()
a = a + three*3
two = input()
a = a + two*2
one = input()
a = a + one

three = input()
b = b + three*3
two = input()
b = b + two*2
one = input()
b = b + one

if a > b:
    print "A"
elif a < b:
    print "B"
else:
    print "T"
