import math 
import time 

#https://programmers.co.kr/learn/courses/30/lessons/60057


# 요건 문자열 제일 앞부터 정해진 길이만큼 자르는게 아닌 어디 포인트든 기준이 될 때.
# 하지만 앞에 반복만 신경써서 뒤에도 반복이 있으면 맞지 않음. 즉, 이 부분에 관해 수정 필요.
def solution_before(s):
    # 문자열 전체 길이를 초기 최소값으로 설정
    answer = len(s)
    # 비교할 문자열 길이: 1개의 길이부터 전체길이의 반 까지 경우의수
    for checkLen in range(1,math.floor(len(s)/2)+1):
        # 문자열 길이마다 임시 길이 설정
        shortLen = len(s)
        # 기준 문자열 시작지점의 경우의 수
        for checkStartPoint  in range(len(s)-checkLen):
            # 재귀함수로 호출 된 것인지 체크 
            # 문자열 압축할 때 숫자 붙는데, 이미 붙은 숫자 있는지 체크 할려고
            deepCheck = False
            checkString = s[checkStartPoint:checkStartPoint+checkLen]
            # print(checkString,checkLen)
            
            # 비교할 문자열이 있는지 체크
            if(checkStartPoint+len(checkString)*2<= len(s)):
                # 중복 문자열 있는지 체크하여 있으면 압축되어 나오는 길이를 리턴
                shortLen = duplicateCheck_before(s, checkStartPoint, checkString, shortLen, deepCheck)
        # 길이 최소값
        if answer > shortLen:
            answer = shortLen
    return answer

# s = 전체 문자열
# checkStartPoint = 기준 문자열 시작점
# shortLen = 압축된 문자열 길이
# deepCheck = 재귀로 호출된 함수인지 확인
def duplicateCheck_before(s, checkStartPoint, checkString, shortLen, deepCheck):
    # print(checkString, s[checkStartPoint+len(checkString):checkStartPoint+len(checkString)*2])
    # 기준 문자열이 다음에 오는 문자열과 같은지 확인
    if checkString == s[checkStartPoint+len(checkString):checkStartPoint+len(checkString)*2]:
        if deepCheck:
            shortLen -= len(checkString)
        else:
            shortLen += 1 - len(checkString)
        # print(shortLen)
        
        # 기준 문자열 다다음 문자열과 비교를 위해 길이 체크 후 재귀로 압축 문자열 계산.
        if(checkStartPoint+len(checkString)*3<= len(s)):
            shortLen = duplicateCheck_before(s, checkStartPoint+len(checkString), checkString, shortLen,True)
    return shortLen
    
  



# ===================================================================================== #


def solution(s):
    # 문자열 전체 길이를 초기 최소값으로 설정
    answer = len(s)
    # 비교할 문자열 길이: 1개의 길이부터 전체길이의 반 까지 경우의수
    for checkLen in range(1,math.floor(len(s)/2)+1):
        # 문자열 길이마다 임시 길이 설정
        shortLen = len(s)
        # 문자열이 10번 반복되면 숫자가 2개(10) 혹은 그 이상(100, 1000, ...) 되는걸 체크하기 위해
        duplicateCheck = 0
        # 비교할 문자열 길이마다 시작 포인트 지정
        for checkPoint in range(0,len(s)-checkLen+1, checkLen):
            # 비교할 다음 문자열이 있는지 확인(문자열 범위 체크)
            if(len(s)>= checkPoint+2*checkLen):
                print(s[checkPoint:checkPoint+checkLen], s[checkPoint+checkLen:checkPoint+2*checkLen])
                # 기준 문자열과 다음 문자열이 같은지 확인
                if s[checkPoint:checkPoint+checkLen] == s[checkPoint+checkLen:checkPoint+2*checkLen]:
                    # 기준 문자열 이전과도 같으면 숫자 추가 안해도 되니 이를 체크
                    if s[checkPoint:checkPoint+checkLen] == s[checkPoint-checkLen:checkPoint]:
                        # 문자열 범위 넘어가는지 체크
                        if checkPoint != 0:
                            shortLen -= checkLen
                            duplicateCheck += 1
                    else:
                        shortLen += 1 - checkLen
                        duplicateCheck = 2
                else:
                    duplicateCheck = 1
                print("duplicateCheck: ",duplicateCheck)
                if(duplicateCheck == 10):
                    shortLen += 1
                if(duplicateCheck == 100):
                    shortLen += 1
                if(duplicateCheck == 1000):
                    shortLen += 1
        if shortLen< answer:
            answer = shortLen
            # deepCheck = False
            # if checkPoint != 0:
                # print(s[checkPoint:checkPoint+checkLen],s[checkPoint-checkLen:checkPoint])
                # if s[checkPoint:checkPoint+checkLen] != s[checkPoint-checkLen:checkPoint]:
                    # shortLen = duplicateCheck(s, shortLen, checkPoint, checkLen, deepCheck)
            # print(checkPoint)
            
    return answer

# def duplicateCheck(s, shortLen, checkPoint, checkLen, deepCheck):
#     if 






s1 = "aabbaccc"
s2 = "ababcdcdababcdcd"
s3 = "abcabcdede"
s4 ="abcabcabcabcdededededede"
s5 = "xababcdcdababcdcd"
s6 = "aaaaaaaaaaaabcd"
s7 = "xxxxxxxxxxyyy"
# print(factorial(500))

start = time.time() 

print(solution(s6))

# def factorial(n): 
#   if(n > 1): 
#     return n * factorial(n - 1) 
#   else: 
#     return 1
# math.factorial(212345) 

end = time.time() 
print(end-start)