import hashlib
import os

# Define a common password and a secret pepper (stored in app config/env variables)
PASSWORD = "user123password"
PEPPER = "SuperSecretGlobalPepperAppVariable2026!"

print(f"Original Password: {PASSWORD}\n")

# 1. WITHOUT SALT (Vulnerable to Rainbow Tables)
# Hashing the same password twice always yields the exact same hash value.
hash_no_salt_1 = hashlib.sha256(PASSWORD.encode()).hexdigest()
hash_no_salt_2 = hashlib.sha256(PASSWORD.encode()).hexdigest()

print("[1. Without Salt]")
print(f"Hash 1: {hash_no_salt_1}")
print(f"Hash 2: {hash_no_salt_2}")
print(f"Hashes match? {hash_no_salt_1 == hash_no_salt_2} (Vulnerable!)\n")

# 2. WITH SALT (Defeats Rainbow Tables)
# Generating a unique, random salt for each distinct hashing process.
salt_1 = os.urandom(16)
salt_2 = os.urandom(16)

# Combine password with unique salts before hashing
hash_with_salt_1 = hashlib.sha256(salt_1 + PASSWORD.encode()).hexdigest()
hash_with_salt_2 = hashlib.sha256(salt_2 + PASSWORD.encode()).hexdigest()

print("[2. With Salt]")
print(f"Salt 1 (hex): {salt_1.hex()}")
print(f"Hash 1:       {hash_with_salt_1}")
print(f"Salt 2 (hex): {salt_2.hex()}")
print(f"Hash 2:       {hash_with_salt_2}")
print(f"Hashes match? {hash_with_salt_1 == hash_with_salt_2} (Secure against rainbow tables!)\n")

# 3. WITH PEPPER (Protects against database leaks)
# Combine the password, a unique salt, and the secret application pepper.
salt_3 = os.urandom(16)
combined_input = salt_3 + PASSWORD.encode() + PEPPER.encode()
hash_with_pepper = hashlib.sha256(combined_input).hexdigest()

print("[3. With Salt and Pepper]")
print(f"Salt 3 (hex):    {salt_3.hex()}")
print(f"Pepper (secret): [Hidden from Database]")
print(f"Final Hash:      {hash_with_pepper}")
