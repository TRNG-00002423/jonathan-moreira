import random

rand_number = random.randint(1,100)
total_attempts = 7
number_attempts = 0

while number_attempts < total_attempts:
    print(f"{rand_number}")
    user_input = int(input("Please guess a random number from 1 to 100!\n"))
    
    if user_input == rand_number:
        number_attempts += 1
        print(f"You got it!!!\n"
              f"The random number was: {rand_number}\n"
              f"Number of attempts used: {number_attempts}")
        break
    elif user_input > rand_number:
       print(f"Too high!") 
       number_attempts += 1
       print(f"Attempts left: {total_attempts - number_attempts}")
    elif user_input < rand_number:
       print(f"Too low!") 
       number_attempts += 1
       print(f"Attempts left: {total_attempts - number_attempts}")
else:
    print(f"No attempts left :(\n"
        f"The random number was {rand_number}")


       