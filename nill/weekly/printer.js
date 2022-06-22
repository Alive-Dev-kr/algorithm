// https://programmers.co.kr/learn/courses/30/lessons/42587

/* 
1. 각 문서마다 프린트 우선순위를 알 수 있도록 맵핑
2. 뒤에 우선순위가 있는것을 파악하기 위해 정렬된 우선순위 배열을 비교군으로 둠
3. 우선순위 높은걸 찾았으면 프린트 순서를 나타내는 배열에 나타내고 맵핑된 배열과 비교군에서 잘라냄
4. 없으면 맵핑된 배열에 맨 뒤로 보냄
5. 반복.
*/
function solution(priorities, location) {
  let answer = 0;
  let copiedPriorities = [...priorities];
  // printing Order를 배열로 나타낼 수 있게 하는 변수 0으로 초기화
  let printingOrder = new Array(priorities.length).fill(0);
  let printMap = [];
  // 몇번째 printing order인지 세는 변수
  let cnt = 1;
  for (const i in priorities) {
    printMap[i] = { key: parseInt(i), priority: priorities[i] };
  }
  // console.log(printingOrder);
  copiedPriorities.sort((a, b) => b - a);
  while (printMap[0]) {
    if (printMap[0].priority === copiedPriorities[0]) {
      copiedPriorities.splice(0, 1);
      printingOrder[printMap[0].key] = cnt;
      cnt++;
      printMap.splice(0, 1);
    } else {
      printMap.push(printMap[0]);
      printMap.splice(0, 1);
    }
  }
  answer = printingOrder[location];
  return answer;
}

let priorities1 = [2, 1, 3, 2];
let priorities2 = [1, 1, 9, 1, 1, 1];
let location1 = 2;
let location2 = 0;

console.log(solution(priorities1, location1)); // 1
console.log(solution(priorities2, location2)); // 5
