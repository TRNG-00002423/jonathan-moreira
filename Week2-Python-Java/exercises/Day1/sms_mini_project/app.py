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

@app.post("/students")
def add_student():
    student = request.get_json()

    student_id = len(students) + 1
    student["id"] = student_id
    students.append(student)

    return jsonify({"id" : student_id,
                    "name" : student["name"],
                    "course" : student["course"]}), 201

@app.put("/students/<int:id>")
def update_student(id):

    if id > len(students):
        return "The student ID does not exsits", 404
    
    
    student = request.get_json()
    student["id"] = id

    students[id - 1] = student

    return jsonify({"id" : student["id"],
                    "name" : student["name"],
                    "course" : student["course"]})

@app.delete("/students/<int:id>")
def delete_student(id):
    if id > len(students):
        return "The student ID does not exsits", 404
    
    students.pop(id-1)

    return jsonify({"message" : "Student deleted successfully"})

if __name__ == "__main__":
    # Runs in the developer test mode
    app.run(debug=True)