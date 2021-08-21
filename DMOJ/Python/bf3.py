from functools import reduce

num = int(input())

def factors(n):    
  return set(reduce(list.__add__, 
  ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

f = (factors(num))

while (len(f) != 2): 
  num += 1
  f = factors(num)
print (num)
