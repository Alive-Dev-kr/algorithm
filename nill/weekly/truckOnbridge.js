// https://programmers.co.kr/learn/courses/30/lessons/42583?language=javascript

function solution(bridge_length, weight, truck_weights) {
  let answer = 0;

  /* 
    1. 다리를 건너는 트럭을 구간별로 나눈 배열로 생각
    2. 해당 구간에 트럭이 없으면 0 - 그러므로 처음 다리는 0으로 초기화 
    3. 한 타임당 트럭 한대가 순서대로 배열을 한칸씩 움직인다고 생각해야 함.
    4. 배열 끝에서 처음 방향으로 옮겨 지는 방식으로 shift와 push 사용.
    5. 다리 위 즉, 배열에 있는 수의 합이 weight 보다 높으면 다음 트럭은 배열에 넣지 못함.
    6. shift나 push를 먼저 하지 않고 우선은 shift하고 push했을 경우의 무게와 다리의 한계 무게 비교.
    7. 무게가 넘으면 다음 트럭 무게 대신 0 push
  */

  let tempTrucks = [];
  tempTrucks.length = bridge_length;
  tempTrucks.fill(0);
  let tempWeight = 0;

  for (w of truck_weights) {
    while (tempWeight - tempTrucks[0] + w > weight) {
      tempWeight -= tempTrucks[0];
      tempTrucks.shift();
      tempTrucks.push(0);
      answer += 1;
      console.log(tempTrucks, answer, "up");
    }
    tempWeight -= tempTrucks[0];
    tempTrucks.shift();
    tempWeight += w;
    tempTrucks.push(w);
    answer += 1;
    console.log(tempTrucks, answer, "down");
  }

  answer += bridge_length;

  return answer;
}

let bridge_length1 = 2;
let bridge_length2 = 100;
let bridge_length3 = 100;
let weight1 = 10;
let weight2 = 100;
let weight3 = 100;
let truck_weights1 = [7, 4, 5, 6]; //8
let truck_weights2 = [10]; //101
let truck_weights3 = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]; //110

console.log(solution(bridge_length2, weight2, truck_weights2));
