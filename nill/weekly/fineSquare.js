// https://programmers.co.kr/learn/courses/30/lessons/62048

function solution(w, h) {
  // BigInt로 계산 안해도 통과는 됨.
  // Number 원시값이 안정적으로 나타낼 수 있는 최대치 값은
  // 2^53-1 = 9,007,199,254,740,991(Number.MAX_SAFE_INTEGER) < 10억^2
  let answer = BigInt(0);
  let long = Math.max(w, h);
  let short = Math.min(w, h);
  let gcd = 1;
  for (let i = 0; i <= short; i++) {
    if (w % i === 0 && h % i === 0) {
      gcd = i;
    }
  }

  // 대각선 선이 1*1의 단위 정사각형으로 진입할 때 가로 선으로 진입하는 세로선으로 진입하는지에 따라
  // 잘려진 단위 정사각형의 개수를 구할 수 있는데, 이는 가로 + 세로 - 1 이다.
  // -1은 처음에 진입할 때 가로와 세로의 합점에서 진입하므로...
  answer = BigInt(w) * BigInt(h) - BigInt(gcd * (short / gcd + long / gcd - 1));

  return answer.toString() * 1;
}

/* 
실패한 기존 코드
	- 일정하게 나오는 패턴(최대공약수)에서 직선의 기울기에 따라 그어진 사각형을 찾으려 했음.

function solution(w, h) {
  let answer = 1;
  let bigIntAnswer = BigInt(0);
  let long = 0;
  let short = 0;
  let maxM = 1;
  let partLinedSquare = 0;
  if (w >= h) {
    long = w;
    short = h;
  } else {
    long = h;
    short = w;
  }

  for (let i = short; i >= 2; i--) {
    if (long % i === 0) {
      maxM = i;
      break;
    }
  }

  let minLong = long / maxM;
  let minShort = short / maxM;
  let ratio = minLong / minShort;
  let floorRatio = Math.floor(minLong / minShort);
  if (ratio - floorRatio > 0.5) {
    partLinedSquare = (floorRatio + 2) * minShort - 2;
  } else if (ratio - floorRatio === 0) {
    partLinedSquare = floorRatio * minShort;
  } else {
    partLinedSquare = (floorRatio + 1) * minShort;
  }

  bigIntAnswer = BigInt(w) * BigInt(h) - BigInt(partLinedSquare * maxM);
  answer = bigIntAnswer.toString() * 1;
  return answer;
} */

let w1 = 1;
let h1 = 1;

console.log(w1 * h1 - 2 * h1);
console.log(solution(w1, h1));
