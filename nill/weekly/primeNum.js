// https://programmers.co.kr/learn/courses/30/lessons/42839?language=javascript

function solution(numbers) {
  let answer = 0;
  let allNum = new Set();

  const getAllNum = (numArray, n, makingNum) => {
    for (const i in numArray) {
      let copyArray = [...numArray];
      // copy한 이유는 이 안에서 makingNum 이용하고 있는데, for문 돌리고 있는데 변경해 버리면 로직이...
      let copyMakingNum = makingNum;
      copyMakingNum += copyArray[i];

      // 011 => 11
      copyMakingNum = parseInt(copyMakingNum);
      copyArray.splice(i, 1);
      if (copyMakingNum.toString().length >= n) {
        if (copyMakingNum >= 2) {
          allNum.add(copyMakingNum);
        }
      } else {
        getAllNum(copyArray, n, copyMakingNum);
      }
    }
  };

  for (const i in numbers) {
    getAllNum(numbers, parseInt(i) + 1, 0);
  }
  console.log(allNum);

  primeCheck: for (const num of allNum) {
    if ((num === 2) | (num === 3)) {
      answer += 1;
    } else {
      for (let a = 2; a <= Math.sqrt(num); a++) {
        if (num % a === 0) {
          continue primeCheck;
        }
      }
      answer += 1;
    }
  }
  return answer;
}

const numbers1 = "17";
const numbers2 = "011";
console.log(solution(numbers1));
console.log(solution(numbers2));
