month = input()
day = input()

if month > 2:
    print "After"
elif month == 2 and day > 18:
    print "After"
elif month == 2 and day < 18:
    print "Before"
elif month < 2:
    print "Before"
elif month == 2 and day == 18:
    print "Special"
