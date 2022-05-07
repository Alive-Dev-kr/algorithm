// https://programmers.co.kr/learn/courses/30/lessons/17680

function solution(cacheSize, cities) {
  let answer = 0;
  let cache = [];
  let lowercaseCities = cities.map((city) => city.toLowerCase());

  for (i in lowercaseCities) {
    let cacheIndexCheck = cache.indexOf(lowercaseCities[i]);
    if (cacheIndexCheck >= 0) {
      answer += 1;

      // *두번째 실패요소... cache 중복 관리
      // 비교할 요소가 캐시 마지막 인덱스에 있다면 넘어가고 없으면 기존에 있던걸 자르고 push
      if (cache.indexOf(lowercaseCities[i]) !== cache.length - 1) {
        cache.splice(cacheIndexCheck, 1);
        cache.push(lowercaseCities[i]);
      }
    } else {
      answer += 5;
      if (cache.length < cacheSize) {
        cache.push(lowercaseCities[i]);
        console.log(cache);

        // *첫번째 실패요소... cache가 0일 때
      } else if (cacheSize > 1) {
        cache.splice(0, 1);
        cache.push(lowercaseCities[i]);
      }
    }
  }
  return answer;
}

const cacheSize1 = 3;
const cacheSize2 = 3;
const cacheSize3 = 2;
const cacheSize4 = 5;
const cacheSize5 = 2;
const cacheSize6 = 0;
const cacheSize7 = 0;
const cities1 = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]; //50
const cities2 = ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]; //21
const cities3 = [
  "Jeju",
  "Pangyo",
  "Seoul",
  "NewYork",
  "LA",
  "SanFrancisco",
  "Seoul",
  "Rome",
  "Paris",
  "Jeju",
  "NewYork",
  "Rome",
]; //60
const cities4 = [
  "Jeju",
  "Pangyo",
  "Seoul",
  "NewYork",
  "LA",
  "SanFrancisco",
  "Seoul",
  "Rome",
  "Paris",
  "Jeju",
  "NewYork",
  "Rome",
]; //52
const cities5 = ["Jeju", "Pangyo", "NewYork", "newyork"]; //16
const cities6 = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]; //25
const cities7 = ["Jeju", "Jeju"]; //10

// console.log(solution(cacheSize1, cities1));
// console.log(solution(cacheSize2, cities2));
// console.log(solution(cacheSize3, cities3));
// console.log(solution(cacheSize4, cities4));
// console.log(solution(cacheSize5, cities5));
// console.log(solution(cacheSize6, cities6));
console.log(solution(cacheSize7, cities7));
