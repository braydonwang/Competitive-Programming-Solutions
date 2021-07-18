whole = None
numerator = input()
denominator = input()

if numerator > denominator:
    x = denominator + 1
    whole = numerator/denominator
    numerator = numerator - (denominator*whole)
elif numerator < denominator:
    x = numerator + 1

for i in range(2,x):
    if numerator % i == 0 and denominator % i == 0:
        numerator = numerator/i
        denominator = denominator/i

if whole != None and denominator > 1:
    print str(whole), str(numerator) + "/" + str(denominator)
elif whole != None and denominator == 1:
    print whole
elif numerator == 0 and denominator > 0:
    print "0"
elif whole > 0 and numerator == 0 and denominator == 0:
    print whole
elif whole == None and numerator > 0 and denominator > 0:
    print str(numerator) + "/" + str(denominator)
