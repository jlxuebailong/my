
def print_max(x, y = 0, *nums):
    '''Print the max num of num sequence.

    :param x:
    :param y:
    :param nums:
    :return:
    '''
    max = x
    if y > max:
        max = y
    for n in nums:
        if n > max:
            max = n
    print('Max is:', max)

print_max(1, 2)
print(print_max.__doc__)
help(print_max)