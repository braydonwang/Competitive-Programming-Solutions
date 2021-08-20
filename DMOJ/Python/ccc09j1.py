count = 1
total = 91

while count <= 3:
    number = int(input())
    if count % 2 == 0:
        total = total + (number*3)
    elif count % 2 != 0:
        total = total + number
    count = count + 1

print "The 1-3-sum is", total
