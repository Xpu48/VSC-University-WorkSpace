import time
import pyotp

# 1. SETUP: Generate a random base32 secret key for the user
secret_key = pyotp.random_base32()
print(f"Generated Secret Key: {secret_key}\n")

# Initialize the TOTP object with our secret key
totp = pyotp.TOTP(secret_key)

# 2. PROVISIONING: Generate the URI string for an authenticator app (like Google Authenticator)
provisioning_url = totp.provisioning_uri(
    name="user@example.com", issuer_name="SecureApp"
)
print("[Provisioning URI / QR Code Data]")
print(f"{provisioning_url}\n")

# 3. GENERATION: Simulate the phone app generating the current token
current_code = totp.now()
print("[Token Generation]")
print(f"Current 6-Digit Code: {current_code}\n")

# 4. VERIFICATION: Test verification logic matching an actual login event
print("[Verification System Testing]")

# Test 1: Immediate verification with the correct code
is_valid_now = totp.verify(current_code)
print(f"Verifying code '{current_code}' immediately: Valid = {is_valid_now}")

# Test 2: Verification with an completely invalid code
is_valid_wrong = totp.verify("123456")
print(f"Verifying incorrect code '123456': Valid = {is_valid_wrong}")

# Test 3: Simulating code expiration (TOTP tokens expire every 30 seconds)
print("\nWaiting 30 seconds for the token to expire...")
time.sleep(30)

is_valid_expired = totp.verify(current_code)
print(f"Verifying old code '{current_code}' after 30s: Valid = {is_valid_expired}")
print(f"New current valid token is now: {totp.now()}")