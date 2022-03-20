// https://programmers.co.kr/learn/courses/30/lessons/42584?language=java

// 길이만큼 0으로 초기화
createZeroArray = function (len) {
  // console.log(new Array(3));  ---- [ <3 empty items> ]
  return new Array(len).fill(0);
};

function solution(prices) {
  //answer 배열 0으로 prices 길이만큼 초기화
  answer = createZeroArray(prices.length);

  for (let i = 0; i < prices.length; i++) {
    let j = i + 1;
    console.log(i);
    // prices[j]는 비교할 가격
    while (j < prices.length) {
      // 다음 배열이 있으면 무조건 1초가 지난것 이므로 +1
      answer[i] += 1;
      if (prices[i] <= prices[j]) {
        j += 1;
      } else {
        // 가격이 떨어졌으면 다음 배열은 비교하면 안되므로 while 탈출
        // j = prices.length;
        break;
      }
    }
  }
  return answer;
}

prices1 = [1, 2, 3, 2, 3];
console.log(solution(prices1));
