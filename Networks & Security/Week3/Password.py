import math
import string

def analyze_password(password):
    score = 0
    feedback = []
    
    # 1. Common Password Check
    common_passwords = ["123456", "password", "qwerty", "123456789", "Pass123"]
    if password in common_passwords:
        return {
            "score": 0,
            "entropy": 0,
            "verdict": "Very Weak (Commonly Used Password)",
            "feedback": ["This password is on a blacklist of common breaches. Change it immediately."]
        }

    # 2. Length Check
    length = len(password)
    if length >= 12:
        score += 2
        feedback.append("Excellent length (12+ characters).")
    elif length >= 8:
        score += 1
        feedback.append("Good length (8+ characters).")
    else:
        feedback.append("Too short (Under 8 characters).")

    # 3. Character Variety Check & Pool Size Calculation
    has_lower = any(c in string.ascii_lowercase for c in password)
    has_upper = any(c in string.ascii_uppercase for c in password)
    has_digit = any(c in string.digits for c in password)
    has_symbol = any(c in string.punctuation for c in password)

    pool_size = 0
    if has_lower: 
        score += 1
        pool_size += 26
    if has_upper: 
        score += 1
        pool_size += 26
    if has_digit: 
        score += 1
        pool_size += 10
    if has_symbol: 
        score += 1
        pool_size += len(string.punctuation) # 32 standard symbols

    # 4. Entropy Calculation
    if pool_size > 0 and length > 0:
        entropy = length * math.log2(pool_size)
    else:
        entropy = 0

    # Determine final verdict based on score (Max score = 6)
    if score >= 5:
        verdict = "Strong"
    elif score >= 3:
        verdict = "Moderate"
    else:
        verdict = "Weak"

    return {
        "score": score,
        "entropy": round(entropy, 2),
        "verdict": verdict,
        "feedback": feedback
    }

# --- Test the Code ---
test_passwords = ["Pass123", "MyP@ssw0rd"]
for pwd in test_passwords:
    result = analyze_password(pwd)
    print(f"Password: {pwd}")
    print(f"  Verdict: {result['verdict']}")
    print(f"  Score:   {result['score']}/6")
    print(f"  Entropy: {result['entropy']} bits")
    print(f"  Details: {', '.join(result['feedback'])}\n")
