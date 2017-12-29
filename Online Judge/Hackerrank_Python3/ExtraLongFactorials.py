import math
import decimal
# You are given an integer . Print the factorial of this number.
# Input
# Input consists of a single integer N, where 1<N<100
#
# Output
# Print the factorial of .
#
# Example
# For an input of 25, you would print 155112100...
#
# Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations.
# Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.
#
# We recommend solving this challenge using BigIntegers.

def extraLongFactorials(n):
    print(math.factorial(n))

# Python supports big integer naturally