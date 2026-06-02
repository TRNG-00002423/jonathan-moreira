age = 17
price = 19.99
name = "Alice"
is_active = True
result = None

print("Variable exploration: ")
print(f"age         ={age}          (type: {type(age)})\n"
      f"price       ={price}        (type: {type(price)})\n"
      f"name        ={name}         (type: {type(name)})\n"
      f"is_active   ={is_active}    (type: {type(is_active)})\n"
      f"result      ={result}       (type: {type(result)})\n")

print("Operators Demo: ")
print(f"{age} // 5      = {age // 5} (floor division)\n"
      f"{age} / 5       = {age / 5} (true division)\n"
      f"{name} * 3      = {name * 3}\n"
      f"{is_active} +  {is_active}  = {is_active + is_active + (not is_active)}\n")

print(f"Precision Gotcha\n"
      f"0.1 + 0.2 = {0.1 + 0.2}\n")

a = [1,2,3]
b = [1,2,3]
c = a
print(f"a==b    {a==b}\n"
      f"a is b    {a is b}")
