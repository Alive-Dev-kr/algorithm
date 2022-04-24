// https://programmers.co.kr/learn/courses/30/lessons/12981?language=javascript

function solution(n, words) {
  let answer = [0, 0];

  for (let i in words) {
    if (i >= 1) {
      if (words[i][0] !== words[i - 1][words[i - 1].length - 1]) {
        answer = [(i % n) + 1, parseInt(i / n) + 1];
        break;
      }
    }
    if (i >= n) {
      let tempArr = words.slice(0, i);
      if (tempArr.indexOf(words[i]) >= 0) {
        answer = [(i % n) + 1, parseInt(i / n) + 1];
        break;
      }
    }
  }
  return answer;
}

const n1 = 3;
const words1 = ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"];
const n2 = 5;
const words2 = [
  "hello",
  "observe",
  "effect",
  "take",
  "either",
  "recognize",
  "encourage",
  "ensure",
  "establish",
  "hang",
  "gather",
  "refer",
  "reference",
  "estimate",
  "executive",
];
const n3 = 2;
const words3 = ["hello", "one", "even", "never", "now", "world", "draw"];

console.log(solution(n1, words1)); //[3,3]
console.log(solution(n2, words2)); //[0,0]
console.log(solution(n3, words3)); //[1,3]
