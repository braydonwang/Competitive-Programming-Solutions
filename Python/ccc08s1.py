x = True
cities = ["Hi"]
temp = []

while cities[-1] != "Waterloo":
    if x:
        cities.remove("Hi")
        x = False
    a, b = map(str, raw_input().split())
    b = int(b)
    cities.append(a)
    temp.append(b)

temp, cities = zip(*sorted(zip(temp,cities)))
print cities[0]
