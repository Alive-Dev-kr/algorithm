// https://programmers.co.kr/learn/courses/30/lessons/12945

//

function solution(n) {
  let answer = 0;
  answer = fibonacci(n);
  return answer;
}

function fibonacci(n) {
  let test = {};
  test = {
    [1]: 3,
  };
  test = { ...test, [2]: 9 };
  console.log(test);
  if (n === 2) {
    return 1;
  } else if (n === 3) {
    return 2;
  } else {
    return fibonacci(n - 2) + fibonacci(n - 1);
  }
}

let n1 = 3;
let n2 = 5;

console.log(solution2(5)); // 2
// console.log(solution2(n2)); // 5

// ==========================================================

let memo = {};
function solution2(n) {
  let answer = 0;
  answer = fibonacci3(n);
  return answer;
}

function fibonacci2(n, fibonacciMemo) {
  if (n in fibonacciMemo) {
    return fibonacciMemo[n];
  } else {
    if (n - 1 in fibonacciMemo && n - 2 in fibonacciMemo) {
      fibonacciMemo = { ...fibonacciMemo, n: fibonacciMemo[n - 1] + fibonacciMemo[n - 2] };
      return fibonacciMemo[n - 1] + fibonacciMemo[n - 2];
    }
    return fibonacci2(n - 1, fibonacciMemo) + fibonacci2(n - 2, fibonacciMemo);
  }
}

function fibonacci3(n) {
  if (n in memo) {
    return memo.n;
  } else {
    fibonacci3 = fibonacci3(n - 1) + fibonacci3(n - 2);
  }
}
