def num_zeros(n):
    if n == 0:
        return 1
    if n < 10:
        return 0
    
    #z = n % 10 == 0 and 1 or 0
    z = (n % 10 == 0) if 1 else 0
    z += num_zeros(int(n / 10))
    return z

print(num_zeros(101010))