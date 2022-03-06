# https://programmers.co.kr/learn/courses/30/lessons/43165
from itertools import *
def solution(numbers, target):
    cntCheck = 0
    answer = 0
    # 부호 체크 0 == '-' / 1 == '+'
    checkSign = [0,1]
    # 부호 중복순열 리스트
    singProductList = list(product(checkSign, repeat=len(numbers)))
    print(singProductList)
    print(len(singProductList))
    
    for singProduct in singProductList:
        # 임시로 계산된 값
        temp = 0
        for i in range(len(singProduct)):
            cntCheck += 1
            if singProduct[i] == 0:
                temp -= numbers[i]
            if singProduct[i] == 1:
                temp += numbers[i]
        if temp == target:
            answer += 1
    print("cntCheck",cntCheck)
    return answer

# answer = 5
numbers = [1,1,1,1,1]
target = 3
# answer = 2
numbers2 = [4,1,2,1]
target2 = 4

print(solution(numbers, target))