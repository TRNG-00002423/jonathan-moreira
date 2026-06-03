scores = [88, 92, 75, -1, 63, 95, 81, 70, -5, 55, 100, 78, -999, 90, 85]

sentinel_value = -999

def grade_processor(scores):
    valid_scores = []
    grade_counts = {
        "A": 0,
        "B": 0,
        "C": 0,
        "D": 0,
        "F": 0
    }

    for index, score in enumerate(scores):
        if score == sentinel_value:
            break

        if score < 0:
            continue

        valid_scores.append(score)

        if score >= 90:
            grade = 'A'
        elif score >= 80:
            grade = 'B'
        elif score >= 70:
            grade = 'C'
        elif score >= 60:
            grade = 'D'
        else:
            grade = 'F'

        grade_counts[grade] += 1

        print(f"Index: {index}: {grade}")
        
    return valid_scores, grade_counts


def class_average(valid_scores):
    if len(valid_scores) == 0:
        return 0
    
    return sum(valid_scores) / len(valid_scores)
    

def class_lowest(valid_scores):
    return min(valid_scores)

def class_highest(valid_scores):
    return max(valid_scores)


# Testing program
valid_scores, grade_counts = grade_processor(scores)
avg = class_average(valid_scores)
lowest = class_lowest(valid_scores)
highest = class_highest(valid_scores)

print(f"\nRESULTS"
      f"\nAverage:      {avg:>16}"
      f"\nLowest:       {lowest:>16}"
      f"\nHighest:      {highest:16}"
      f"\nDistribution: {grade_counts}")
