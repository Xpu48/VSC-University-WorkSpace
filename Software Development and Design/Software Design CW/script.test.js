const { CheckTitle, CheckFirstName, CheckLastName, CheckEmail, CheckDateOfBirth, CheckAddress, validateForm } = require('./script');

// Mock the validEmailDomains variable
global.validEmailDomains = ["gmail.com", "yahoo.com", "outlook.com"];

describe('Validation Tests', () => {
  // Title Tests
  test('should return MR for valid title MR', () => {
    expect(CheckTitle('MR')).toBe('MR');
  });

  test('should return MRS for valid title MRS', () => {
    expect(CheckTitle('MRS')).toBe('MRS');
  });

  test('should throw an error if title is empty', () => {
    expect(() => CheckTitle('')).toThrow('No title provided');
  });

  test('should throw an error if title is invalid', () => {
    expect(() => CheckTitle('INVALID')).toThrow('Invalid title provided');
  });

  // First Name Tests
  test('should return Shorter Name for valid first name Bob', () => {
    expect(CheckFirstName('Bob')).toBe('Shorter Name');
  });

  test('should return Longer Name for valid first name Johnathan', () => {
    expect(CheckFirstName('Johnathan')).toBe('Longer Name');
  });

  test('should throw an error if first name is too long', () => {
    expect(() => CheckFirstName('Bobthebuildercanwefixityeswecan')).toThrow('Invalid name provided');
  });

  test('should throw an error if first name contains numbers', () => {
    expect(() => CheckFirstName('John123')).toThrow('Invalid name provided');
  });

  test('should throw an error if first name is empty', () => {
    expect(() => CheckFirstName('')).toThrow('No name provided');
  });

  // Last Name Tests
  test('should return Shorter Name for valid last name Lee', () => {
    expect(CheckLastName('Lee')).toBe('Shorter Name');
  });

  test('should return Longer Name for valid last name Smithy', () => {
    expect(CheckLastName('Smithy')).toBe('Longer Name');
  });

  test('should throw an error if last name is too long', () => {
    expect(() => CheckLastName('SmithenSmithenSmithenSmithenSmithen')).toThrow('Invalid name provided');
  });

  test('should throw an error if last name contains numbers', () => {
    expect(() => CheckLastName('Smith123')).toThrow('Invalid name provided');
  });

  test('should throw an error if last name is empty', () => {
    expect(() => CheckLastName('')).toThrow('No name provided');
  });

  // Email Tests
  test('should return the email for valid email', () => {
    expect(CheckEmail('bobthebuilder@gmail.com')).toBe('bobthebuilder@gmail.com');
  });

  test('should throw an error if email domain is invalid', () => {
    expect(() => CheckEmail('SeanTheSheep@bob.com')).toThrow('Invalid email domain');
  });

  test('should throw an error if email is empty', () => {
    expect(() => CheckEmail('')).toThrow('No email provided');
  });

  // Date of Birth Tests
  test('should return the date of birth for valid date', () => {
    expect(CheckDateOfBirth('01', '01', '2000')).toBe('01/01/2000');
  });

  test('should throw an error if date of birth format is invalid', () => {
    expect(() => CheckDateOfBirth('01', '01', '00')).toThrow('Invalid Year provided');
  });

  test('should throw an error if date of birth is empty', () => {
    expect(() => CheckDateOfBirth('', '', '')).toThrow('Incomplete Date of Birth provided');
  });

  // Address Tests
  test('should return the address for valid address', () => {
    expect(CheckAddress('1 Road Street')).toBe('1 Road Street');
  });

  test('should return the address for valid address', () => {
    expect(CheckAddress('1 Bob lane')).toBe('1 Bob lane');
  });

  test('should throw an error if address is empty', () => {
    expect(() => CheckAddress('')).toThrow('No Address provided');
  });
});