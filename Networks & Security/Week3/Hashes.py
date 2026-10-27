import hashlib
import time
import bcrypt


def demonstrate_hashing():
    password = "SuperSecretPassword123"
    password_bytes = password.encode("utf-8")

    print(f"Original Password: {password}\n")

    # MD5 Hashing
    start_time = time.perf_counter()
    md5_hash = hashlib.md5(password_bytes).hexdigest()
    md5_time = time.perf_counter() - start_time
    print(f"MD5 Hash:    {md5_hash}")
    print(f"MD5 Time:    {md5_time:.8f} seconds\n")

    # SHA-256 Hashing
    start_time = time.perf_counter()
    sha256_hash = hashlib.sha256(password_bytes).hexdigest()
    sha256_time = time.perf_counter() - start_time
    print(f"SHA-256 Hash: {sha256_hash}")
    print(f"SHA-256 Time: {sha256_time:.8f} seconds\n")

    # Bcrypt Hashing (Secure, adaptive slow hashing)
    start_time = time.perf_counter()
    salt = bcrypt.gensalt()
    bcrypt_hash = bcrypt.hashpw(password_bytes, salt)
    bcrypt_time = time.perf_counter() - start_time
    print(f"Bcrypt Hash: {bcrypt_hash.decode('utf-8')}")
    print(f"Bcrypt Time: {bcrypt_time:.5f} seconds\n")

    # Simulating Login Verification
    correct_attempt = "SuperSecretPassword123"
    wrong_attempt = "WrongPassword123"

    is_correct = bcrypt.checkpw(correct_attempt.encode("utf-8"), bcrypt_hash)
    print(f"Attempt with '{correct_attempt}': Match = {is_correct}")

    is_wrong = bcrypt.checkpw(wrong_attempt.encode("utf-8"), bcrypt_hash)
    print(f"Attempt with '{wrong_attempt}': Match = {is_wrong}")

if __name__ == "__main__":
    demonstrate_hashing()
