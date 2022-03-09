# https://programmers.co.kr/learn/courses/30/lessons/42578

from itertools import combinations

def solution(clothes):
    # answer를 기준으로 곱해 나갈 꺼라서 0이 아닌 1로 (경우의수 찾기)
    answer = 1
    dict = {}
    # 데이터 다루기 쉽게 재가공
    for each_clothes in clothes:
        # key가 없으면 생성하고 배열로 value 값 넣고, 있으면 append
        if(each_clothes[1] in dict):
            dict[each_clothes[1]].append(each_clothes[0])
        else:
            dict[each_clothes[1]] = [each_clothes[0]]
    print(dict)
    # 안 입는것 까지 생각해서 +1
    for part in dict:
        answer *= len(dict[part])+ 1
    # 다 안 입는 경우의 수 -1
    answer -= 1
    return answer




clothes_1 = [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
clothes_2 = [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]

print(solution(clothes_1)) #5
print(solution(clothes_2)) #3