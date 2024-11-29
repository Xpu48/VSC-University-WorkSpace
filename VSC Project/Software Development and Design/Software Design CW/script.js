// Test function to handle assertions and log results
function test(message, assertion) {
  try {
    const result = assertion();
    console.log(result ? `Pass: ${message}` : `Fail: ${message}`);
  } catch (error) {
    console.error(`Error: ${message} - ${error.message}`);
  }
}

// Function to run tests with error handling
function runTestWithErrorHandling(message, assertion) {
  test(message, () => {
    try {
      return assertion();
    } catch (error) {
      return error.message;
    }
  });
}

// Function to check all constraints for the form
function Checker() {
  const testCases = [
    // Title Tests
    { type: "Title", value: "MR", expected: "MR" },
    { type: "Title", value: "MRS", expected: "MRS" },
    { type: "Title", value: "", expected: "No title provided" },
    { type: "Title", value: "INVALID", expected: "Invalid title provided" },

    // First Name Tests
    { type: "FirstName", value: "Bob", expected: "Shorter Name" },
    { type: "FirstName", value: "Johnathan", expected: "Longer Name" },
    {
      type: "FirstName",
      value: "Bobthebuildercanwefixityeswecan",
      expected: "Invalid name provided",
    },
    { type: "FirstName", value: "John123", expected: "Invalid name provided" },
    { type: "FirstName", value: "", expected: "No name provided" },

    // Last Name Tests
    { type: "LastName", value: "Lee", expected: "Shorter Name" },
    { type: "LastName", value: "Smithy", expected: "Longer Name" },
    {
      type: "LastName",
      value: "SmithenSmithenSmithenSmithenSmithen",
      expected: "Invalid name provided",
    },
    { type: "LastName", value: "Smith123", expected: "Invalid name provided" },
    { type: "LastName", value: "", expected: "No name provided" },

    // Email Tests
    {
      type: "Email",
      value: "bobthebuilder@gmail.com",
      expected: "bobthebuilder@gmail.com",
    },
    {
      type: "Email",
      value: "SeanTheSheep@bob.com",
      expected: "Invalid email provided",
    },
    { type: "Email", value: "", expected: "No email provided" },

    // Date of Birth Tests
    { type: "DateOfBirth", value: "01/01/2000", expected: "01/01/2000" },
    {
      type: "DateOfBirth",
      value: "01/01/00",
      expected: "Invalid Date of Birth provided",
    },
    { type: "DateOfBirth", value: "", expected: "No Date of Birth provided" },

    // Address Tests
    { type: "Address", value: "1 Road Street", expected: "1 Road Street" },
    { type: "Address", value: "1 Bob lane", expected: "1 Bob lane" },
    { type: "Address", value: "", expected: "No Address provided" },
  ];

  // Run all tests from the above
  testCases.forEach(({ type, value, expected }) => {
    const message = `Check ${type} - ${expected}`;
    const assertion = () => {
      switch (type) {
        case "Title":
          return CheckTitle(value) === expected;
        case "FirstName":
          return CheckFirstName(value) === expected;
        case "LastName":
          return CheckLastName(value) === expected;
        case "Email":
          return CheckEmail(value) === expected;
        case "DateOfBirth":
          if (value === "") {
            return CheckDataOfBirth("", "", "") === expected;
          } else {
            const [day, month, year] = value.split("/");
            return CheckDateOfBirth(day, month, year) === expected;
          }
        case "Address":
          return CheckAddress(value) === expected;
        case "Postcode":
          return CheckPostcode(value) === expected;
        default:
          throw new Error("Unknown test type");
      }
    };

    if (expected.includes("Invalid") || expected.includes("No")) {
      runTestWithErrorHandling(message, assertion);
    } else {
      test(message, assertion);
    }
  });
}

document.addEventListener("DOMContentLoaded", () => {
  // Array to store valid email domains to be cross referenced
  function EmailDomains() {
    return fetch(
      "https://raw.githubusercontent.com/Kikobeats/free-email-domains/master/domains.json"
    )
      .then((response) => {
        if (!response.ok) {
          // Check if the response is valid
          throw new Error(`error: ${response.status}`);
        }
        return response.json();
      })
      .then((data) => {
        validEmailDomains = data;
      })
      .catch((error) => console.error("Error fetching email domains:", error));
  }

  // Populate the dropdown box with a list of countries
  function ListCountries() {
    fetch("https://restcountries.com/v3.1/all?fields=name")
      .then((response) => {
        if (!response.ok) {
          // Check if the response is valid
          throw new Error(`error: ${response.status}`);
        }
        return response.json();
      })
      .then((data) => {
        data.sort((a, b) => a.name.common.localeCompare(b.name.common)); //this ensures the countries are in alphabetical order
        const countrySelect = document.getElementById("country"); // Get the select element
        data.forEach((country) => {
          const option = document.createElement("option"); // Create an option choice for each country
          option.value = country.cca2; //
          option.text = country.name.common;
          countrySelect.appendChild(option);
        });
      })
      .catch((error) => console.error("Error fetching country data:", error));
  }

  EmailDomains().then(() => {
    Checker(); // Run tests after email domains are fetched otherwise the checker doesn't know what the valid domains are
  });
  ListCountries();
});

// Validation Functions
function CheckTitle(title) {
  const validTitles = ["MR", "MRS", "MISS", "MS", "DR"];
  if (title === "") throw new Error("No title provided");
  if (validTitles.includes(title)) return title;
  throw new Error("Invalid title provided");
}

function CheckFirstName(firstName) {
  if (firstName === "") throw new Error("No name provided");
  if (/[^a-zA-Z]/.test(firstName)) throw new Error("Invalid name provided");
  if (firstName.length > 30) throw new Error("Invalid name provided");
  return firstName.length <= 5 ? "Shorter Name" : "Longer Name";
}

function CheckLastName(lastName) {
  if (lastName === "") throw new Error("No name provided");
  if (/[^a-zA-Z]/.test(lastName)) throw new Error("Invalid name provided");
  if (lastName.length > 30) throw new Error("Invalid name provided");
  return lastName.length <= 5 ? "Shorter Name" : "Longer Name";
}

function CheckEmail(email) {
  if (email === "") throw new Error("No email provided");

  const emailFormat = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailFormat.test(email)) throw new Error("Invalid email format");

  const domain = email.split("@")[1];
  if (!validEmailDomains.includes(domain))
    throw new Error("Invalid email domain");

  return email;
}

function CheckDateOfBirth(day, month, year) {
  if (day === "" || month === "" || year === "")
    throw new Error("Incomplete Date of Birth provided");

  const dayInt = parseInt(day);
  const monthInt = parseInt(month);
  const yearInt = parseInt(year);

  // NaN is a method to ensure that if it not a number it throws an error
  if (Number.isNaN(dayInt) || Number.isNaN(monthInt) || Number.isNaN(yearInt))
    throw new Error("Invalid Date of Birth provided");

  if (dayInt < 1 || dayInt > 31) throw new Error("Invalid Day provided");
  if (monthInt < 1 || monthInt > 12) throw new Error("Invalid Month provided");
  if (yearInt < 1900 || yearInt > new Date().getFullYear())throw new Error("Invalid Year provided");

  // The format of how the dates will be put together.
  return `${dayInt.toString().padStart(2, "0")}/${monthInt.toString().padStart(2, "0")}/${yearInt}`;
}

function CheckAge(age) {
  if (age === "") throw new Error("No Age provided");
  if (age < 0 || age > 165) throw new Error("Invalid Age provided");
  return age;
}

function CheckAddress(address) {
  if (address === "") throw new Error("No Address provided");
  if (/[^a-zA-Z0-9\s]/.test(address))
    throw new Error("Invalid Address provided");
  return address;
}

function CheckCountry(country) {
  if (country === "") throw new Error("No Country Provided");
  return country;
}

// This was the only way I could find to not get an error when opening the website
// Turns the functions to become global
window.CheckEmail = CheckEmail;
window.CheckDateOfBirth = CheckDateOfBirth;
window.CheckAge = CheckAge;
window.CheckAddress = CheckAddress;
window.CheckCountry = CheckCountry;
window.CheckFirstName = CheckFirstName;
window.CheckLastName = CheckLastName;
window.CheckTitle = CheckTitle;

// exports for testin
if (typeof module !== "undefined" && module.exports) {
  module.exports = {
    CheckTitle,
    CheckFirstName,
    CheckLastName,
    CheckEmail,
    CheckDateOfBirth,
    CheckAge,
    CheckAddress,
    CheckCountry,
  };
}
