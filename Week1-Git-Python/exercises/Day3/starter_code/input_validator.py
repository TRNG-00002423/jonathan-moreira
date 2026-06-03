def validate_password(password):
    requirements = {
        "valid" : False,
        "error" : []
    }
    if len(password) < 8:
        requirements["error"].append("Password must be at least 8 characters long")
    
    return requirements

print(validate_password("abc"))