userYear = input()
newYear = -1
count = userYear

while newYear < userYear:
    if userYear >= 987 and userYear <= 9875: # problem here
        count = count + 1
        lastDigit = count % 10
        secondLastDigit = count / 10 % 10
        secondDigit = count / 100 % 10
        firstDigit = count / 1000 % 10
        if lastDigit != secondLastDigit and lastDigit != secondDigit and lastDigit != firstDigit and secondLastDigit != secondDigit and secondLastDigit != firstDigit and secondDigit != firstDigit:
            newYear = count
    elif userYear >= 100 and userYear <= 986: # problem here
        count = count + 1
        lastDigit = count % 10
        secondDigit = count / 10 % 10
        firstDigit = count / 100 % 10
        if lastDigit != secondDigit and lastDigit != firstDigit and secondDigit != firstDigit:
            newYear = count
    elif userYear >= 10 and userYear <= 99:
        count = count + 1
        lastDigit = count % 10
        firstDigit = count / 10 % 10
        if lastDigit != firstDigit:
            newYear = count
    elif userYear >= 9876 and userYear <= 10000:
        count = count  + 1
        lastDigit = count % 10
        secondLastDigit = count / 10 % 10
        thirdDigit = count / 100 % 10
        secondDigit = count / 1000 % 10
        firstDigit = count / 10000 % 10
        if lastDigit != secondLastDigit and lastDigit != secondDigit and lastDigit != firstDigit and secondLastDigit != secondDigit and secondLastDigit != firstDigit and secondDigit != firstDigit and thirdDigit != lastDigit and thirdDigit != secondLastDigit and thirdDigit != secondDigit and thirdDigit != firstDigit:
            newYear = count
    elif userYear >= 0 and userYear <= 9:
        count = count + 1
        newYear = count

print newYear
