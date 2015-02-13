'''

fvcproductions

august 1, 2014

A Byte of Python

mini-exercises

'''

# printing strings

print("Hello World")
print("This is Python 3")

# decimal (.) precision of 3 for float

#'{0:.3}'.format(1/3) 

# fill with underscores (_) with the text
# centered (^) to 11 width

'{0:_^11}'.format('hello') 

# keyword based

'{name} wrote {book}'.format(name = 'FVCproductions', book = 'A Chronicle')

# multi-line strings

s = '''Yo I be multi.
Check me out tho.'''

print(s)

# expressions

length = 3;
breadth = 2;

area = length * breadth

print('Area is', area)

# if statement - guessing game

number = 23
guess = int(input('Enter an integer : '))

if guess == number:
	print('''Congrats, you guessed right!
		But you don't get anything!!! BAHAHA''')
elif guess < number:
	print("No, a bit higher there...")
else:
	print("Nah, a bit lower...")

print("That's it - done diddly done")

# while statement - guessing game





