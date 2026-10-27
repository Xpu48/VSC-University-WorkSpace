import math
import string
import bcrypt
import pyotp

# Mock database: { username: {"password_hash": bytes, "totp_secret": str} }
user_database = {}


def is_strong_password(password):
    """Checks if a password meets our complexity requirements."""
    if len(password) < 8:
        return False

    # Block obvious choices
    blacklist = ["123456", "password", "qwerty", "123456789", "Pass123"]
    if password in blacklist:
        return False

    # Track how many different character types are used
    pool_size = 0
    score = 0

    if any(c in string.ascii_lowercase for c in password):
        score += 1
        pool_size += 26
    if any(c in string.ascii_uppercase for c in password):
        score += 1
        pool_size += 26
    if any(c in string.digits for c in password):
        score += 1
        pool_size += 10
    if any(c in string.punctuation for c in password):
        score += 1
        pool_size += 32

    # Calculate bit entropy
    entropy = len(password) * math.log2(pool_size) if pool_size > 0 else 0

    # Minimum threshold: must use at least 3 types and have decent randomness
    if score < 3 or entropy < 40:
        return False

    return True


def register(username, password):
    """Validates, hashes, and provisions 2FA for a new user account."""
    if username in user_database:
        print(f"Error: User '{username}' already exists.")
        return False

    if not is_strong_password(password):
        print(f"Error: Password for '{username}' is too weak or too common.")
        return False

    # Hash the password securely (bcrypt embeds the salt automatically)
    pw_hash = bcrypt.hashpw(password.encode("utf-8"), bcrypt.gensalt())

    # Set up 2FA secret
    mfa_secret = pyotp.random_base32()

    # Save to our mock DB
    user_database[username] = {
        "password_hash": pw_hash,
        "totp_secret": mfa_secret,
    }

    print(f"User '{username}' registered successfully!")
    print(f"  Hash: {pw_hash.decode('utf-8')}")
    print(f"  MFA Key: {mfa_secret}\n")
    return True


def login(username, password, mfa_token):
    """Verifies user credentials and their time-based 2FA token."""
    if username not in user_database:
        print("Login Failed: User not found.")
        return False

    account = user_database[username]

    # 1. Check password
    if not bcrypt.checkpw(password.encode("utf-8"), account["password_hash"]):
        print("Login Failed: Incorrect password.")
        return False

    # 2. Check 2FA token
    totp_verifier = pyotp.TOTP(account["totp_secret"])
    if not totp_verifier.verify(mfa_token):
        print("Login Failed: Invalid or expired 2FA code.")
        return False

    print(f"Success: Welcome back, {username}!")
    return True


# --- Test/Demo Flow ---
if __name__ == "__main__":
    # Test registration filters
    register("alice", "Pass123")  # Expected: Fails (weak)
    register("bob", "SecureP@ss2026!")  # Expected: Passes (strong)

    print("\n--- Simulating Login Sequence ---")

    # Emulate Bob checking his phone app for his current code
    bobs_secret = user_database["bob"]["totp_secret"]
    phone_app = pyotp.TOTP(bobs_secret)
    current_token = phone_app.now()

    print(f"Bob's authenticator app reads: {current_token}\n")

    # Try logging in with the correct credentials
    login("bob", "SecureP@ss2026!", current_token)

    # Try logging in with a bad token
    login("bob", "SecureP@ss2026!", "000000")