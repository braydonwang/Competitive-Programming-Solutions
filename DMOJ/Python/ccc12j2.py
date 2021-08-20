rising = False
diving = False
constant = False
no = False

depth1 = input()
depth2 = input()
depth3 = input()
depth4 = input()

if depth1 < depth2:
    rising = True
elif depth1 > depth2:
    diving = True
elif depth1 == depth2:
    constant = True

if depth2 < depth3 and rising == True:
    rising = True
elif depth2 > depth3 and diving == True:
    diving = True
elif depth2 == depth3 and constant == True:
    constant = True
else:
    no = True

if depth3 < depth4 and rising == True:
    rising = True
elif depth3 > depth4 and diving == True:
    diving = True
elif depth3 == depth4 and constant == True:
    constant = True
else:
    no = True

if rising == True and no == False:
    print "Fish Rising"
elif diving == True and no == False:
    print "Fish Diving"
elif constant == True and no == False:
    print "Fish At Constant Depth"
else:
    print "No Fish"
