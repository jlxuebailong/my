
print('Hello World!')
print('''
--------------------------
Hello World!
---------------------------
''')

print("""
--------------------------
Fuck...........
--------------------------
""")


age = 20
name = "Swaroop"

print("{0} was {1} years old when he wrote this book".format(name, age))
print(name +" was "+ str(age) +" years old when he wrote this book")
print('{0:_^11}'.format('hello'))

print('a', end='')
print('b', end='')
print('cdefg', end='\n')

print('What\'s your name?')
print("What\'s your name? \
        My name is Rito")

#原始字段符
print(R'What\'s your name?')
print(R'^\d?((\.)\d?)?$')

'''
n = 23
times = 0
max_guess_times = 10
while times < max_guess_times:
    guess = int(input('Enter an integer(Left ' + str(max_guess_times - times) + ' times): '))
    if guess == n:
        print('Congratulations, you guessed it.')
        print('(but you do not win any prizes!)')
        break
    elif guess < n:
        print('No,it is a little higher than that.')
    else:
        print('No,it is a little lower than that.')
    times += 1
else:
    print('The while loop is over.')
print('Done')
'''

for i in range(1, 5):
    print(i)
else:
    print('The for loop is over')
for i in [1, 2, 3, 4]:
    print(i)
else:
    print('The for loop is over')

def say_hello(name, times = 1):
    print('hello', name * times)

say_hello('Caca', 5)

x = 50
def foo(n):
    print('X is', n)
    global x
    x = 2
    print('Changed local x to', x)
foo(x)
print('X is stall', x)
print(max(1,2,4))

shoplist = ['mango', 'apple', 'coconut', 'banana']
print(shoplist)
shoplist[0] = 'caca'
print(shoplist)

