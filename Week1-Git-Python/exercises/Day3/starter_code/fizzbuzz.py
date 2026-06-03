def fizzbuzz(n):
    for i in range(1, n + 1):
        if (i%3 == 0) and (i%5 == 0) and (i%7 == 0):
            print(f"FizzBuzzBoom")
        elif (i%3 == 0) and (i%5 == 0):
            print(f"FizzBuzz")
        elif (i%3 == 0) and (i%7 == 0):
            print(f"FizzBoom")
        elif (i%5 == 0) and (i%7 == 0):
            print(f"BuzzBoom")
        elif i%3 == 0:
            print(f"Fizz")
        elif i%5 == 0:
            print(f"Buzz")  
        elif i%7 == 0:
            print(f"Boom")
        else:
            print(f"{i}")

fizzbuzz(105)