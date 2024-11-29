document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("submitBtn").addEventListener("click", function () {
      const input = document.getElementById("gradeInput").value.trim();
      // Remove leading/trailing spaces
      const numberPattern = /^[0-9]+(.[0-9]+)?$/;
      // Accept integer and floating-point numbers
      if (!numberPattern.test(input)) {
        document.getElementById("message").innerText =
          "Invalid input. Please enter a validreturn";
      }
      const grade = parseFloat(input); // Use parseFloat to handle decimals
      3;
      if (grade < 0 || grade > 100) {
        document.getElementById("message").innerText =
          "Invalid grade. Please enter a number";
      } else {
        const message = grade >= 40 ? "Pass" : "Fail";
        document.getElementById("message").innerText = message;
      }
  
      // Get the table element from the page
      const table = document.querySelector("table");
      // Parse table rows and cells
      const rows = [...table.querySelectorAll("tr")].map((row) => {
        const cells = [...row.querySelectorAll("td, th")];
        return cells.map((cell) => cell.innerText.trim());
      });
      // Store the table data in sessionStorage
      sessionStorage.setItem("gradesTable", JSON.stringify(rows));
      console.log("Table data has been stored in sessionStorage:", rows);
    });
  });