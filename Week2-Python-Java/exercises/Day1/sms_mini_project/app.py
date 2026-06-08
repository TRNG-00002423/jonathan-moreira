from flask import Flask, request, jsonify

# Starting/Creating a flask app
app = Flask(__name__)
app.json.sort_keys = False

students = [
    {
        "id": 1,
        "name": "Alice",
        "course": "Computer Science"
    },
    {
        "id": 2,
        "name": "Bob",
        "course": "Data Science"
    }
]

@app.get("/students")
def show_students():
    return jsonify(students)

@app.get("/students/<int:id>")
def show_student_by_id(id):
    return jsonify(students[id-1])

if __name__ == "__main__":
    # Runs in the developer test mode
    app.run(debug=True)