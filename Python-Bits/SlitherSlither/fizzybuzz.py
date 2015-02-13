"""

fvcproductions

fizzybuzz.py 

for fizzbuzz problem which is where the program prints integers from 1 to 100 but for multiples of 3 prints "Fizz" instead of the number and for multiples of five prints "Buzz" and for numbers which are the multiples of 3 and 5 (or 15), it prints "FizzBuzz"

"""

def fizzybuzz(number):
	
	#if number has a remainder of 0 when divided by 15 (multiple of 3 and 5), return string "FizzBuzz"
	if number % 15 == 0: 
		return "FizzBuzz"
   	
	#else if number has a remainder of 0 when divided by 3 (multiple of 3), return string "Fizz" 
	elif number % 3 == 0: 
		return "Fizz"
	
	#else if number has a remainder of 0 when divided by 5 (multiple of 5), return string "Buzz"
	elif number % 5 == 0:
		return "Buzz"
    
	#else if number isn't multiple of 3, 5, or both - just returns number
	else:
		return str(number)
		
#combines coma with return strings (multiple line results) of the function fizzybuzz for the numbers in the range of 1 to 100
print ", ".join(fizzybuzz(x) for x in xrange(1, 101)) 


"""

---sample output---

1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, FizzBuzz, 31, 32, Fizz, 34, Buzz, Fizz, 37, 38, Fizz, Buzz, 41, Fizz, 43, 44, FizzBuzz, 46, 47, Fizz, 49, Buzz, Fizz, 52, 53, Fizz, Buzz, 56, Fizz, 58, 59, FizzBuzz, 61, 62, Fizz, 64, Buzz, Fizz, 67, 68, Fizz, Buzz, 71, Fizz, 73, 74, FizzBuzz, 76, 77, Fizz, 79, Buzz, Fizz, 82, 83, Fizz, Buzz, 86, Fizz, 88, 89, FizzBuzz, 91, 92, Fizz, 94, Buzz, Fizz, 97, 98, Fizz, Buzz

"""
