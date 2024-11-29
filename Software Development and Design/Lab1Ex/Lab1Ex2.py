""" 
class Report:
    def __init__(self, data):
        self.data = data

    def print_report(self):
        print("Report:")
        for item in self.data:
            print(f"Item: {item}")

    def save_to_file(self, filename):
        with open(filename, 'w') as file:
            for item in self.data:
                file.write(f"Item: {item}\n")
"""

import json

class Report:
    def __init__(self, data):
        self.data = data

    def print_report(self):
        print("Report:")
        for item in self.data:
            print(f"Item: {item}")

class ReportSaver:
    def save(self, report, filename, format_type="text"):
        if format_type == "text":
            self.save_as_text(report, filename)
        elif format_type == "json":
            self.save_as_json(report, filename)

    def save_as_text(self, report, filename):
        with open(filename, 'w') as file:
            for item in report.data:
                file.write(f"Item: {item}\n")

    def save_as_json(self, report, filename):
        with open(filename, 'w') as file:
            json.dump({"report": report.data}, file)
