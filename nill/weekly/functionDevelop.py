# https://programmers.co.kr/learn/courses/30/lessons/42586
import math
def solution(progresses, speeds):
    answer = []
    # 각각의 작업 일수
    workDays = []
    for workDay in range(len(progresses)):
        workDays.append(math.ceil((100 - progresses[workDay]) / speeds[workDay]))
    print(workDays)
    # 비교 기준이 될 이전 작업의 걸린 일수
    checkDays = 0
    # 한번 배포될 때 몇개가 배포되는지 새는 변수
    cnt = 0
    for i in range(len(workDays)):
        # 첫 작업은 무조건 그 작업일 수에 맞춰 배포 됨.
        if i == 0:
            checkDays = workDays[i]
            cnt = 1
        if i > 0:
            # 이전 작업과 일수 비교
            if checkDays >= workDays[i]:
                cnt += 1
            else:
                answer.append(cnt)
                cnt = 1
                checkDays = workDays[i]
        # 맨 마지막 배포는 answer에 append 안됐으므로...
        if i == len(workDays) - 1:
            answer.append(cnt)
    return answer
  
progresses1 = [93, 30, 55]
speeds1 = [1, 30, 5]	
progresses2 = [95, 90, 99, 99, 80, 99]
speeds2 = [1, 1, 1, 1, 1, 1]

print(solution(progresses1, speeds1))
print(solution(progresses2, speeds2))