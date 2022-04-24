// https://programmers.co.kr/learn/courses/30/lessons/12945

// 재귀 호출 깊이 런타임 오류
// https://jireh.tistory.com/14

function solution(n) {
  let answer = 0;
  let fiboMemo = { [0]: 0, [1]: 1 };
  let fibo = function (n) {
    if (n in fiboMemo) {
      return fiboMemo[n];
    }
    fiboMemo = { ...fiboMemo, [n]: fibo(n - 1) + fibo(n - 2) };
    console.log(fiboMemo);
    return fiboMemo[n];
  };
  answer = fibo(n);
  return answer;
}

function solution2(n) {
  let answer = 0;
  let fiboMemo = [BigInt(0), BigInt(1)];
  let fibo = function (n) {
    if (n in fiboMemo) {
      return BigInt(fiboMemo[n]);
    }
    fiboMemo[n] = fibo(n - 1) + fibo(n - 2);
    return BigInt(fiboMemo[n]);
  };
  answer = (fibo(n) % BigInt(1234567)) + "";
  answer = parseInt(answer);
  return answer;
}

function solution3(n) {
  let answer = [0, 1];
  if (n <= 1) return answer[n];
  for (var i = 2; i < n + 1; i++) {
    answer.push((answer[i - 2] + answer[i - 1]) % 1234567);
  }
  return answer[n];
}
console.log(solution3(999));

// Dynamic programming
// https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182
