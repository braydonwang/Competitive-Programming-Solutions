num1 = int(input())
num2 = int(input())
num3 = int(input())

if (num1 > num2 and num1 < num3) or (num1 > num3 and num1 < num2):
    middle = num1
elif (num2 > num1 and num2 < num3) or (num2 > num3 and num2 < num1):
    middle = num2
else:
    middle = num3

print middle
