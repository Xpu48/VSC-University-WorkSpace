import hashlib
import time

# A small sample wordlist of common passwords
DICTIONARY = [
    "password123",
    "qwerty",
    "admin",
    "letmein1",
    "user123password",  # Our target password from Section 3
    "welcome1",
    "football",
]


def simulate_dictionary_attack(target_hash, hash_type):
    print(f"Starting dictionary attack on {hash_type} hash...")
    start_time = time.perf_counter()
    attempts = 0

    # Iterate through the common passwords list
    for guess in DICTIONARY:
        attempts += 1
        guess_bytes = guess.encode("utf-8")

        # Hash the guess using the specified algorithm
        if hash_type.lower() == "md5":
            current_hash = hashlib.md5(guess_bytes).hexdigest()
        elif hash_type.lower() == "sha256":
            current_hash = hashlib.sha256(guess_bytes).hexdigest()
        else:
            print("Unsupported hash type.")
            return

        # Compare the result to the target hash
        if current_hash == target_hash:
            duration = time.perf_counter() - start_time
            print(f"✅ SUCCESS! Password found: '{guess}'")
            print(f"Attempts: {attempts} | Time taken: {duration:.6f} seconds\n")
            return guess

    duration = time.perf_counter() - start_time
    print("❌ FAILED! Password not in dictionary.")
    print(f"Attempts: {attempts} | Time taken: {duration:.6f} seconds\n")
    return None


if __name__ == "__main__":
    # Target password to crack
    target_password = "user123password"
    print(f"Target Password to Crack: {target_password}\n")

    # Generate the target hashes (unsalted)
    target_md5 = hashlib.md5(target_password.encode()).hexdigest()
    target_sha256 = hashlib.sha256(target_password.encode()).hexdigest()

    # Run the simulated attacks
    simulate_dictionary_attack(target_md5, "MD5")
    simulate_dictionary_attack(target_sha256, "SHA-256")
