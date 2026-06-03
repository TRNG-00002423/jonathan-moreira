scores = [88, 92, 75, -1, 63, 95, 81, 70, -5, 55, 100, 78, -999, 90, 85]
sentinel_value = -999

def grade_processor(scores):
    
    for index, score in enumerate(scores):
        if score == sentinel_value:
            break
        elif score < 0:
            continue
        elif score >= 90:
            score = 'A'
        elif score >= 80:
            score = 'B'
        elif score >= 70:
            score = 'C'
        elif score >= 60:
            score = 'D'
        else:
            score = 'F'

        print(f"Index: {index}: {score}")

grade_processor(scores)