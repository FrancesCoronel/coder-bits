'''
FVCproductions
RSAPublicKeyAlgorithm_Program4.py
Discrete Structures
November 2014
Written in Python 2.7
'''

# simplified values for RSA Public Key Algorithm 
# published in 5.4.2

p  =  23
q  =  31
n  =  29
z  =  p*q
h  =  (p-1)*(q-1) # phi symbol
s  =  569

# encryption method

def encrypt(aString):
	
	chars = []
	
	for x in range(len(aString)):
		chars.append(ord(aString[x]))
	
	encrypted = []
	
	for y in chars:
		encrypted.append((y**n) % z )
	
	return encrypted

# decryption method

def decrypt(integers):
	
	decrypted = ""
	
	for i in integers:
		decrypted += chr((i**s) % z)
		
	return decrypted
	
def printEncrypted(encryptedMessage):
	
	toPrint = ""
	
	for char in encryptedMessage:
		toPrint += str(char) + " "
	
	print toPrint
	

# main method

# asking for message from user

message = raw_input("Enter Message\n")

print "\nClear Text Message"
print message

# encrypting given message

encryptedMessage = encrypt(message)

print "\nEncrypted Message"

printEncrypted(encryptedMessage)

# decrypting the encrypted message

decryptedMessage = decrypt(encryptedMessage)

print "\nDecrypted Message"
print decryptedMessage

raw_input("\nEnter Message\n")

''' --- SAMPLE OUTPUT ---
Enter Message
This is a test message.

Clear Text Message
This is a test message.

Encrypted Message
241 637 354 644 280 354 644 280 132 280 461 4 644 461 280 250 4 644 644 132 214 4 184 

Decrypted Message
This is a test message.

Enter Message

'''