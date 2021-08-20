a, b = map(int, raw_input().split())

add = a + b
if a > b:
    difference = a - b
elif a < b:
    difference = b - a
else:
    difference = 0
product = a * b

if product > add and product > difference:
    print product
elif add > product and add > difference:
    print add
elif difference > product and difference > add:
    print difference
