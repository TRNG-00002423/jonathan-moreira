def validate_password(password):
    requirements = {
        "valid" : False,
        "error" : []
    }
    if len(password) < 8:
        requirements["valid"] = False
        requirements["error"].append("Password must be at least 8 characters long")
    
    if not any(char.isupper() for char in password):
        requirements["valid"] = False
        requirements["error"].append("Password must contain at least one uppercase letter")

    if not any(char.islower() for char in password):
        requirements["valid"] = False
        requirements["error"].append("Password must contain at least one lowercase letter")

    if not any(char.isdigit() for char in password):
        requirements["valid"] = False
        requirements["error"].append("Password must contain at least one digit")

    return requirements

print(validate_password("abc"))
print(validate_password("ABCDEFGH"))    # no lower, no digit, no special