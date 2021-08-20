antonia = 100
david = 100

N = int(raw_input())
for _ in xrange(N):
    a, b = map(int, raw_input().split())
    if a > b:
        david = david - a
    elif a < b:
        antonia = antonia - b

print antonia
print david
